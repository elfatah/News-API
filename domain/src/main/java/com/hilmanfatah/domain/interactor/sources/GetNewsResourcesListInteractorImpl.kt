package com.hilmanfatah.domain.interactor.sources

import com.hilmanfatah.domain.model.SourcesItem
import com.hilmanfatah.domain.repository.SourceRepository
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by hilmanfatah on 1/23/18.
 */
class GetNewsResourcesListInteractorImpl : GetNewsResourcesListInteractor {
    @Inject
    lateinit var sourceRepository: SourceRepository

    @Inject
    constructor()


    override fun execute(category: String, country: String, language: String): Flowable<List<SourcesItem>?> =
            sourceRepository.getSourcesList(category, language, country)
                    .map { it.sources }

}