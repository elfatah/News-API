package com.hilmanfatah.opennewsapi.domain.repository

import com.hilmanfatah.opennewsapi.domain.model.SourceResponse
import io.reactivex.Flowable

/**
 * Created by hilmanfatah on 24/01/18.
 */
interface NewsRepository {
    fun getSourcesList(category: String, country: String, language: String): Flowable<SourceResponse>
}