package com.hilmanfatah.data.repository

import com.hilmanfatah.data.api.NewsService
import com.hilmanfatah.data.articlesToPojos
import com.hilmanfatah.data.articlesToRealm
import com.hilmanfatah.data.realm.RealmNews
import com.hilmanfatah.domain.model.NewsResponse
import com.hilmanfatah.domain.repository.NewsRepository
import io.reactivex.Flowable
import io.realm.Realm
import java.util.*
import javax.inject.Inject

/**
 * Created by hilmanfatah on 24/01/18.
 */
class NewsRepositoryImpl : NewsRepository {
    @Inject
    lateinit var newsService: NewsService

    @Inject
    constructor()

    override fun getNews(source: String): Flowable<NewsResponse> =
            newsService.getNews(source, "a637297ff901442493f6e38209f78c25", "")
                    .map {
                        val realm = Realm.getDefaultInstance()
                        it.articles.let {
                            realm.executeTransaction { realm ->
                                val realmArticle = realm.where(RealmNews::class.java).equalTo("source", source).findAll()
                                realmArticle.deleteAllFromRealm()
                                realm.insertOrUpdate(it!!.articlesToRealm(source))
                            }
                        }

                        it
                    }
                    .onErrorResumeNext(getNewsListCache(source))
                    .startWith(getNewsListCache(source))

    private fun getNewsListCache(source: String): Flowable<NewsResponse> {
        val realm = Realm.getDefaultInstance()
        val articleResponse = NewsResponse()
        val realmArticleList = ArrayList<RealmNews>()
        val realmArticle = realm.where(RealmNews::class.java).equalTo("source", source).findAll()
        realmArticleList.addAll(realmArticle)
        articleResponse.articles = realmArticleList.articlesToPojos()
        return Flowable.just(articleResponse)
    }
}