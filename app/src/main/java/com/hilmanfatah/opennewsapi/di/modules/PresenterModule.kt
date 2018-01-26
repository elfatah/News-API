package com.hilmanfatah.opennewsapi.di.modules

import com.hilmanfatah.opennewsapi.presentation.home.HomePresenter
import com.hilmanfatah.opennewsapi.presentation.home.HomePresenterImpl
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
    fun provideHomePresenter(homePresenter: HomePresenterImpl): HomePresenter = homePresenter
}