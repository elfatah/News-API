package com.hilmanfatah.domain.model

import com.google.gson.annotations.SerializedName

/**
 * Created by hilmanfatah on 1/23/18.
 */
class UrlToLogos {

    @SerializedName("small")
    var small: String? = null

    @SerializedName("large")
    var large: String? = null

    @SerializedName("medium")
    var medium: String? = null
}