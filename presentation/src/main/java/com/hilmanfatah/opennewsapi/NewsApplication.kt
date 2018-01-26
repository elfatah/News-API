package com.hilmanfatah.opennewsapi

import android.app.Application
import android.content.Context
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.stetho.Stetho
import com.hilmanfatah.opennewsapi.di.components.ApplicationComponent
import com.hilmanfatah.opennewsapi.di.components.DaggerApplicationComponent
import com.hilmanfatah.opennewsapi.di.modules.ContextModule
import com.uphyca.stetho_realm.RealmInspectorModulesProvider
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by hilmanfatah on 1/23/18.
 */
class NewsApplication : Application() {
    companion object {
        lateinit var applicationComponent: ApplicationComponent
        lateinit var appContext: Context

    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder().contextModule(ContextModule(this)).build()
        appContext = this
        Realm.init(this)
        val realmConfiguration = RealmConfiguration.Builder()
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.setDefaultConfiguration(realmConfiguration)

        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build())

        Fresco.initialize(this)
    }
}