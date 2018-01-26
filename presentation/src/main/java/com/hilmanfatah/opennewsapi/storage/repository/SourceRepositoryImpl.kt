package com.hilmanfatah.opennewsapi.storage.repository

import com.hilmanfatah.opennewsapi.domain.model.SourceResponse
import com.hilmanfatah.opennewsapi.domain.repository.SourceRepository
import com.hilmanfatah.opennewsapi.storage.api.NewsService
import com.hilmanfatah.opennewsapi.storage.realm.RealmSource
import com.hilmanfatah.opennewsapi.storage.sourcesToPojo
import com.hilmanfatah.opennewsapi.storage.sourcesToRealm
import io.reactivex.Flowable
import io.realm.Realm
import java.util.*
import javax.inject.Inject

/**
 * Created by hilmanfatah on 24/01/18.
 */
class SourceRepositoryImpl : SourceRepository {
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
                                realm.insertOrUpdate(it!!.sourcesToRealm())
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
        sourceResponse.sources = realmSourceList.sourcesToPojo()
        return Flowable.just(sourceResponse)
    }


}