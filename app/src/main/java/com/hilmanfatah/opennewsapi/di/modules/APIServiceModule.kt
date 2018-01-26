package com.hilmanfatah.opennewsapi.di.modules

import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.hilmanfatah.opennewsapi.storage.api.NewsService
import dagger.Module
import dagger.Provides
import io.realm.RealmObject
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by hilmanfatah on 1/23/18.
 */
@Module(includes = [(NetworkModule::class)])
class APIServiceModule {

    @Provides
    @Singleton
    fun apiService(retrofit: Retrofit): NewsService = retrofit.create(NewsService::class.java)

    @Provides
    @Singleton
    fun rxJavaCallAdapter(): RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

    @Provides
    @Singleton
    fun gson(): Gson =
            GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                    .setExclusionStrategies(object : ExclusionStrategy {
                        override fun shouldSkipClass(clazz: Class<*>?): Boolean = false
                        override fun shouldSkipField(f: FieldAttributes?): Boolean = f!!.declaredClass == RealmObject::class.java
                    })
                    .create()

    @Provides
    @Singleton
    fun retrofit(okHttpClient: OkHttpClient, gson: Gson, rxJava2CallAdapterFactory: RxJava2CallAdapterFactory): Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .client(okHttpClient)
            .baseUrl("https://newsapi.org/v1/")
            .build()

}