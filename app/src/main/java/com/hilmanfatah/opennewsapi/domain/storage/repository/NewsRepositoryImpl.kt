package com.hilmanfatah.opennewsapi.domain.storage.repository

import com.hilmanfatah.opennewsapi.api.NewsService
import com.hilmanfatah.opennewsapi.domain.model.SourceResponse
import com.hilmanfatah.opennewsapi.domain.repository.NewsRepository
import com.hilmanfatah.opennewsapi.domain.storage.toPojo
import com.hilmanfatah.opennewsapi.domain.storage.toRealm
import elfatahwashere.com.tokopedianews.storage.model.RealmSource
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

    override fun getSourcesList(category: String, country: String, language: String): Flowable<SourceResponse> =
            newsService.getSources(category, country, language)
                    .map {
                        val realm = Realm.getDefaultInstance()
                        it.sources.let {
                            realm.executeTransaction { realm ->
                                realm.insertOrUpdate(it!!.toRealm())
                            }
                        }

                        it
                    }
                    .onErrorResumeNext(getSourceListCache())
                    .startWith(getSourceListCache())


    private fun getSourceListCache(): Flowable<SourceResponse> {
        val realm = Realm.getDefaultInstance()
        val sourceResponse = SourceResponse()
        val realmSourceList = ArrayList<RealmSource>()
        val realmSource = realm.where(RealmSource::class.java).findAll()
        realmSourceList.addAll(realmSource)
        sourceResponse.sources = realmSourceList.toPojo()
        return Flowable.just(sourceResponse)
    }

}