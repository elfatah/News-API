package com.hilmanfatah.opennewsapi.di.components

import com.hilmanfatah.opennewsapi.di.modules.APIServiceModule
import com.hilmanfatah.opennewsapi.di.modules.RepositoryModule
import com.hilmanfatah.opennewsapi.presentation.news.NewsListActivity
import com.hilmanfatah.opennewsapi.presentation.source.SourceActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by hilmanfatah on 1/23/18.
 */

@Singleton
@Component(modules = [(APIServiceModule::class), (RepositoryModule::class)])
interface ApplicationComponent {
    fun inject(sourceActivity: SourceActivity)
    fun inject(newsListActivity: NewsListActivity)

}