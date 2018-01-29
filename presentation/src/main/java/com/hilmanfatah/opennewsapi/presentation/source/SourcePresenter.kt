package com.hilmanfatah.opennewsapi.presentation.source

import com.hilmanfatah.domain.model.SourcesItem
import io.reactivex.Flowable

/**
 * Created by hilmanfatah on 1/23/18.
 */
interface SourcePresenter {

    fun getSourcesList(): Flowable<List<SourcesItem>?>
}