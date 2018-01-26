package com.hilmanfatah.opennewsapi.di.components

import com.hilmanfatah.opennewsapi.di.modules.APIServiceModule
import com.hilmanfatah.opennewsapi.presentation.home.MainActivity
import com.hilmanfatah.opennewsapi.presentation.news.NewsListActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by hilmanfatah on 1/23/18.
 */

@Singleton
@Component(modules = [(APIServiceModule::class)])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(newsListActivity: NewsListActivity)

}