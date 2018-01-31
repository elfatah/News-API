package com.hilmanfatah.opennewsapi.presentation.news

import com.hilmanfatah.domain.interactor.news.GetNewsListInteractorImpl
import com.hilmanfatah.domain.model.NewsItem
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by Hilman N Fatah on 24/01/18.
 */
class NewsPresenterImpl : NewsPresenter {
    @Inject
    lateinit var newsListInteractorImpl: GetNewsListInteractorImpl

    @Inject
    constructor()

    override fun getArticles(source: String): Flowable<List<NewsItem>?> =
            newsListInteractorImpl.execute(source)


}