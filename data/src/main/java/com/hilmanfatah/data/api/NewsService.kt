package com.hilmanfatah.data.api

import com.hilmanfatah.domain.model.NewsResponse
import com.hilmanfatah.domain.model.SourceResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by hilmanfatah on 1/23/18.
 */
interface NewsService {
    @GET("articles")
    fun getNews(@Query("source") source: String,
                @Query("apiKey") apiKey: String,
                @Query("sortBy") sortBy: String): Flowable<NewsResponse>

    @GET("sources")
    fun getSources(@Query("category") category: String,
                   @Query("language") language: String,
                   @Query("country") country: String): Flowable<SourceResponse>

}