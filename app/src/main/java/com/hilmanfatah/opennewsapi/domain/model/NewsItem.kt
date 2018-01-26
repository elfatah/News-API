package com.hilmanfatah.opennewsapi.domain.model

import com.google.gson.annotations.SerializedName

/**
 * Created by hilmanfatah on 1/23/18.
 */
class NewsItem {
    @SerializedName("publishedAt")
    var publishedAt: String? = null

    @SerializedName("author")
    var author: String? = null

    @SerializedName("urlToImage")
    var urlToImage: String? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("url")
    var url: String? = null
}