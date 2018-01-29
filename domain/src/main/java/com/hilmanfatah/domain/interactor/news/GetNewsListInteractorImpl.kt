package com.hilmanfatah.domain.interactor.news

import com.hilmanfatah.domain.model.NewsItem
import com.hilmanfatah.domain.repository.NewsRepository
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by Hilman N Fatah on 24/01/18.
 */
class GetNewsListInteractorImpl : GetNewsListInteractor {

    @Inject
    lateinit var articleRepository: NewsRepository

    @Inject
    constructor()

    override fun execute(source: String): Flowable<List<NewsItem>?> =
            articleRepository.getNews(source)
                    .map { it.articles }

}