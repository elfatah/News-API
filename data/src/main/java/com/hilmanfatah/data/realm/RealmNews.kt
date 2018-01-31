package com.hilmanfatah.data.realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class RealmNews : RealmObject() {

    var source: String? = null

    var publishedAt: String? = null

    var author: String? = null

    var urlToImage: String? = null

    var description: String? = null

    @PrimaryKey
    var title: String? = null

    var url: String? = null

}