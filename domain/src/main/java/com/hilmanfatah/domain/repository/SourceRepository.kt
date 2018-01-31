package com.hilmanfatah.domain.repository

import com.hilmanfatah.domain.model.SourceResponse
import io.reactivex.Flowable

/**
 * Created by hilmanfatah on 24/01/18.
 */
interface SourceRepository {
    fun getSourcesList(category: String, country: String, language: String): Flowable<SourceResponse>

}