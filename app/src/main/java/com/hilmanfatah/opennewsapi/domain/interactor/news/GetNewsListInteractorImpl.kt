package com.hilmanfatah.opennewsapi.domain.interactor.news

import com.hilmanfatah.opennewsapi.domain.model.ArticlesItem
import com.hilmanfatah.opennewsapi.storage.repository.ArticleRepositoryImpl
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by Hilman N Fatah on 24/01/18.
 */
class GetNewsListInteractorImpl : GetNewsListInteractor {

    @Inject
    lateinit var articleRepository: ArticleRepositoryImpl

    @Inject
    constructor()

    override fun execute(source: String): Flowable<List<ArticlesItem>?> =
            articleRepository.getArticles(source)
                    .map { it.articles }

}