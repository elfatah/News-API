package com.hilmanfatah.opennewsapi.storage.repository

import com.hilmanfatah.opennewsapi.api.NewsService
import com.hilmanfatah.opennewsapi.domain.model.ArticleResponse
import com.hilmanfatah.opennewsapi.domain.repository.ArticleRepository
import com.hilmanfatah.opennewsapi.storage.articlesToPojos
import com.hilmanfatah.opennewsapi.storage.articlesToRealm
import com.hilmanfatah.opennewsapi.storage.realm.RealmArticle
import io.reactivex.Flowable
import io.realm.Realm
import java.util.*
import javax.inject.Inject

/**
 * Created by hilmanfatah on 24/01/18.
 */
class ArticleRepositoryImpl : ArticleRepository {
    @Inject
    lateinit var newsService: NewsService

    @Inject
    constructor()

    override fun getArticles(source: String): Flowable<ArticleResponse> =
            newsService.getArticles(source, "a637297ff901442493f6e38209f78c25", "")
                    .map {
                        val realm = Realm.getDefaultInstance()
                        it.articles.let {
                            realm.executeTransaction { realm ->
                                realm.insertOrUpdate(it!!.articlesToRealm(source))
                            }
                        }

                        it
                    }
                    .onErrorResumeNext(getNewsListCache(source))
                    .startWith(getNewsListCache(source))

    private fun getNewsListCache(source: String): Flowable<ArticleResponse> {
        val realm = Realm.getDefaultInstance()
        val articleResponse = ArticleResponse()
        val realmArticleList = ArrayList<RealmArticle>()
        val realmArticle = realm.where(RealmArticle::class.java).equalTo("source", source).findAll()
        realmArticleList.addAll(realmArticle)
        articleResponse.articles = realmArticleList.articlesToPojos()
        return Flowable.just(articleResponse)
    }
}