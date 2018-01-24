package com.hilmanfatah.opennewsapi.domain.model

import com.google.gson.annotations.SerializedName

/**
 * Created by hilmanfatah on 1/23/18.
 */
class ArticleResponse {
    @SerializedName("sortBy")
    val sortBy: String? = null

    @SerializedName("source")
    val source: String? = null

    @SerializedName("articles")
    var articles: List<ArticlesItem>? = null

    @SerializedName("status")
    val status: String? = null
}