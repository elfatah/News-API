package com.hilmanfatah.opennewsapi.domain.model

import com.google.gson.annotations.SerializedName

/**
 * Created by hilmanfatah on 1/23/18.
 */
class SourceResponse {

    @SerializedName("sources")
    var sources: List<SourcesItem>? = null

    @SerializedName("status")
    val status: String? = null
}