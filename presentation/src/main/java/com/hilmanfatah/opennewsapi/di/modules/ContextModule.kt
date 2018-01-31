package com.hilmanfatah.opennewsapi.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by hilmanfatah on 1/23/18.
 */
@Module
class ContextModule(context: Context) {
    private val appContext = context.applicationContext

    @Provides
    @Singleton
    fun context(): Context {
        return this.appContext
    }
}