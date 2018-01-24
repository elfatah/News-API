package com.hilmanfatah.opennewsapi.domain.interactor.sources

import com.hilmanfatah.opennewsapi.domain.model.SourcesItem
import com.hilmanfatah.opennewsapi.storage.repository.SourceRepositoryImpl
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by hilmanfatah on 1/23/18.
 */
class GetNewsResourcesListInteractorImpl : GetNewsResourcesListInteractor {
    @Inject
    lateinit var sourceRepository: SourceRepositoryImpl

    @Inject
    constructor()


    override fun execute(category: String, country: String, language: String): Flowable<List<SourcesItem>?> =
            sourceRepository.getSourcesList(category, language, country)
                    .map { it.sources }

}