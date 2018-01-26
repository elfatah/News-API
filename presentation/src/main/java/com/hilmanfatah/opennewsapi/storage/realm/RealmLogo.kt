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


open class RealmLogo : RealmObject() {

    var small: String? = null

    var large: String? = null

    var medium: String? = null
}