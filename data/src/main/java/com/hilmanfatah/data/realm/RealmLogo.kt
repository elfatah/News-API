package com.hilmanfatah.data.realm

import io.realm.RealmObject


open class RealmLogo : RealmObject() {

    var small: String? = null

    var large: String? = null

    var medium: String? = null
}