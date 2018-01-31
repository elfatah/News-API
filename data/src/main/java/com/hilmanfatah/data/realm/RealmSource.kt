package com.hilmanfatah.data.realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class RealmSource : RealmObject() {

    var urlsToLogos: RealmLogo? = null

    var name: String? = null

    var description: String? = null

    @PrimaryKey
    var id: String? = null

    var category: String? = null

    var url: String? = null
}