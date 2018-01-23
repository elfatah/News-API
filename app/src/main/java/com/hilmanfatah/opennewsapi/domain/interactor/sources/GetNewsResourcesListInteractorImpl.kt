package com.hilmanfatah.opennewsapi.domain.interactor.sources

import com.hilmanfatah.opennewsapi.api.NewsService
import com.hilmanfatah.opennewsapi.domain.model.SourceResponse
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by hilmanfatah on 1/23/18.
 */
class GetNewsResourcesListInteractorImpl : GetNewsResourcesListInteractor {
    @Inject
    lateinit var newsService: NewsService

    @Inject
    constructor()


    override fun execute(category: String, country: String, language: String): Flowable<SourceResponse> =
            newsService.getSources(category, language, country)

}