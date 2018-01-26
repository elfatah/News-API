package com.hilmanfatah.opennewsapi.di.modules

import android.content.Context
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by hilmanfatah on 1/23/18.
 */
@Module(includes = [(ContextModule::class)])
class NetworkModule {

    @Provides
    @Singleton
    fun chuckInterceptor(context: Context): ChuckInterceptor =
            ChuckInterceptor(context)

    @Provides
    @Singleton
    fun loggingInterceptor(): HttpLoggingInterceptor {
        val inteceptor = HttpLoggingInterceptor()
        inteceptor.level = HttpLoggingInterceptor.Level.BODY
        return inteceptor
    }

    @Provides
    @Singleton
    fun cache(file: File): Cache = Cache(file, 10 * 1000 * 1000)

    @Provides
    @Singleton
    fun file(context: Context): File = File(context.cacheDir, "okhttp_cache")

    @Provides
    @Singleton
    fun okHttpClient(loggingInterceptor: HttpLoggingInterceptor, chuckInterceptor: ChuckInterceptor, cache: Cache) =
            OkHttpClient.Builder()
                    .readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .addInterceptor(loggingInterceptor)
                    .addInterceptor(chuckInterceptor)
                    .cache(cache).build()
}