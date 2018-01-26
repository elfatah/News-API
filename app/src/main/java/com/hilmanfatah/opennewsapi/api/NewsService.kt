package com.hilmanfatah.opennewsapi.api

import com.hilmanfatah.opennewsapi.domain.model.ArticleResponse
import com.hilmanfatah.opennewsapi.domain.model.SourceResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by hilmanfatah on 1/23/18.
 */
interface NewsService {
    @GET("articles")
    fun getArticles(@Query("source") source: String,
                    @Query("apiKey") apiKey: String,
                    @Query("sortBy") sortBy: String): Flowable<ArticleResponse>

    @GET("sources")
    fun getSources(@Query("category") category: String,
                   @Query("language") language: String,
                   @Query("country") country: String): Flowable<SourceResponse>

}