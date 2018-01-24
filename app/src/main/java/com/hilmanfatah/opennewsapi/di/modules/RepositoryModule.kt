package com.hilmanfatah.opennewsapi.di.modules

import com.hilmanfatah.opennewsapi.domain.repository.NewsRepository
import com.hilmanfatah.opennewsapi.domain.storage.repository.NewsRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by hilmanfatah on 24/01/18.
 */
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesNewsRepo(newsRepositoryImpl: NewsRepositoryImpl): NewsRepository = newsRepositoryImpl

}