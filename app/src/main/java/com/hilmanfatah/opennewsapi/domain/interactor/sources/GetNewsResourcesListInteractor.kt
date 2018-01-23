package com.hilmanfatah.opennewsapi.domain.interactor.sources

import com.hilmanfatah.opennewsapi.domain.model.SourceResponse
import io.reactivex.Flowable

/**
 * Created by hilmanfatah on 1/23/18.
 */
interface GetNewsResourcesListInteractor {

    fun execute(category: String, country: String, language: String): Flowable<SourceResponse>
}