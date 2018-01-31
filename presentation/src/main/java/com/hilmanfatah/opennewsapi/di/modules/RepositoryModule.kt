package com.hilmanfatah.opennewsapi.di.modules

import com.hilmanfatah.data.repository.NewsRepositoryImpl
import com.hilmanfatah.data.repository.SourceRepositoryImpl
import com.hilmanfatah.domain.repository.NewsRepository
import com.hilmanfatah.domain.repository.SourceRepository
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