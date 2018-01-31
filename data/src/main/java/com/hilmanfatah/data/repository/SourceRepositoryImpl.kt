package com.hilmanfatah.data.repository

import com.hilmanfatah.data.api.NewsService
import com.hilmanfatah.data.realm.RealmSource
import com.hilmanfatah.data.sourcesToPojo
import com.hilmanfatah.data.sourcesToRealm
import com.hilmanfatah.domain.model.SourceResponse
import io.reactivex.Flowable
import io.realm.Realm
import java.util.*
import javax.inject.Inject

/**
 * Created by hilmanfatah on 24/01/18.
 */
class SourceRepositoryImpl : com.hilmanfatah.domain.repository.SourceRepository {
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
                                val realmSource = realm.where(RealmSource::class.java).findAll()
                                realmSource.deleteAllFromRealm()
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