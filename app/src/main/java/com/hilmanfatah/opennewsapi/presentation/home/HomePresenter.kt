package com.hilmanfatah.opennewsapi.presentation.home

import com.hilmanfatah.opennewsapi.domain.model.SourcesItem
import io.reactivex.Flowable

/**
 * Created by hilmanfatah on 1/23/18.
 */
interface HomePresenter {

    fun getSourcesList(): Flowable<List<SourcesItem>?>
}