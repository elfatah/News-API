package com.hilmanfatah.opennewsapi.domain.model

import com.google.gson.annotations.SerializedName

/**
 * Created by hilmanfatah on 1/23/18.
 */
class SourcesItem {
    @SerializedName("country")
    var country: String? = null

    @SerializedName("urlsToLogos")
    var urlsToLogos: UrlToLogos? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("sortBysAvailable")
    var sortBysAvailable: List<String?>? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("language")
    var language: String? = null

    @SerializedName("id")
    var id: String? = null

    @SerializedName("category")
    var category: String? = null

    @SerializedName("url")
    var url: String? = null
}