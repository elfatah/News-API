/*
 * Copyright (c) 2017.
 *
 * Hilman N Fatah
 * hilmannfatah@gmail.com
 * https://github.com/elfatah
 * https://www.linkedin.com/in/hilman-nur-fatah-107001b6/
 */

package elfatahwashere.com.tokopedianews.storage.model

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