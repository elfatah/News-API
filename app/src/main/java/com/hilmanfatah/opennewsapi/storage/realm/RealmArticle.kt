/*
 * Copyright (c) 2017.
 *
 * Hilman N Fatah
 * hilmannfatah@gmail.com
 * https://github.com/elfatah
 * https://www.linkedin.com/in/hilman-nur-fatah-107001b6/
 */

package com.hilmanfatah.opennewsapi.storage.realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class RealmArticle : RealmObject() {

    var source: String? = null

    var publishedAt: String? = null

    var author: String? = null

    var urlToImage: String? = null

    var description: String? = null

    @PrimaryKey
    var title: String? = null

    var url: String? = null

}