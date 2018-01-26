package com.hilmanfatah.opennewsapi.domain.repository

import com.hilmanfatah.opennewsapi.domain.model.NewsResponse
import io.reactivex.Flowable

/**
 * Created by Hilman N Fatah on 24/01/18.
 */
interface NewsRepository {
    fun getNews(source: String): Flowable<NewsResponse>

}