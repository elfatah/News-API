package com.hilmanfatah.opennewsapi.di.modules

import com.hilmanfatah.opennewsapi.presentation.news.NewsPresenter
import com.hilmanfatah.opennewsapi.presentation.news.NewsPresenterImpl
import com.hilmanfatah.opennewsapi.presentation.source.SourcePresenter
import com.hilmanfatah.opennewsapi.presentation.source.SourcePresenterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by hilmanfatah on 1/23/18.
 */
@Module
class PresenterModule {

    @Provides
    @Singleton
    fun provideHomePresenter(sourcePresenter: SourcePresenterImpl): SourcePresenter = sourcePresenter

    @Provides
    @Singleton
    fun provideNewsPresenter(newsPresenterImpl: NewsPresenterImpl): NewsPresenter = newsPresenterImpl
}