package com.hilmanfatah.opennewsapi.di.modules

import com.hilmanfatah.opennewsapi.domain.repository.NewsRepository
import com.hilmanfatah.opennewsapi.domain.repository.SourceRepository
import com.hilmanfatah.opennewsapi.storage.repository.NewsRepositoryImpl
import com.hilmanfatah.opennewsapi.storage.repository.SourceRepositoryImpl
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
    fun providesSourceRepo(sourceRepository: SourceRepositoryImpl): SourceRepository = sourceRepository

    @Provides
    @Singleton
    fun providesArticleRepo(articleRepositoryImpl: NewsRepositoryImpl): NewsRepository = articleRepositoryImpl

}