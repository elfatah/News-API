package com.hilmanfatah.opennewsapi.domain.repository

import com.hilmanfatah.opennewsapi.domain.model.ArticleResponse
import io.reactivex.Flowable

/**
 * Created by Hilman N Fatah on 24/01/18.
 */
interface ArticleRepository {
    fun getArticles(source: String): Flowable<ArticleResponse>

}