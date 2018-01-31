package com.hilmanfatah.domain.interactor.sources

import com.hilmanfatah.domain.model.SourcesItem
import io.reactivex.Flowable

/**
 * Created by hilmanfatah on 1/23/18.
 */
interface GetNewsResourcesListInteractor {

    fun execute(category: String, country: String, language: String): Flowable<List<SourcesItem>?>
}