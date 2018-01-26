package com.hilmanfatah.opennewsapi.domain.interactor.news

import com.hilmanfatah.opennewsapi.domain.model.NewsItem
import com.hilmanfatah.opennewsapi.storage.repository.NewsRepositoryImpl
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by Hilman N Fatah on 24/01/18.
 */
class GetNewsListInteractorImpl : GetNewsListInteractor {

    @Inject
    lateinit var articleRepository: NewsRepositoryImpl

    @Inject
    constructor()

    override fun execute(source: String): Flowable<List<NewsItem>?> =
            articleRepository.getNews(source)
                    .map { it.articles }

}