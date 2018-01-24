package com.hilmanfatah.opennewsapi.presentation.news

import com.hilmanfatah.opennewsapi.domain.interactor.news.GetNewsListInteractorImpl
import com.hilmanfatah.opennewsapi.domain.model.ArticlesItem
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

    override fun getArticles(source: String): Flowable<List<ArticlesItem>?> =
            newsListInteractorImpl.execute(source)


}