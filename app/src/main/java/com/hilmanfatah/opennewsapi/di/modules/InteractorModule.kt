package com.hilmanfatah.opennewsapi.di.modules

import com.hilmanfatah.opennewsapi.domain.interactor.sources.GetNewsResourcesListInteractor
import com.hilmanfatah.opennewsapi.domain.interactor.sources.GetNewsResourcesListInteractorImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by hilmanfatah on 1/23/18.
 */
@Module
class InteractorModule {

    @Provides
    @Singleton
    fun provideGetNewsResourcesListInteractor(interactor: GetNewsResourcesListInteractorImpl): GetNewsResourcesListInteractor = interactor

}