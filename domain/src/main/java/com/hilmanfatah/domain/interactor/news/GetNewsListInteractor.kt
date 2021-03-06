package com.hilmanfatah.domain.interactor.news

import com.hilmanfatah.domain.model.NewsItem
import io.reactivex.Flowable

/**
 * Created by Hilman N Fatah on 24/01/18.
 */
interface GetNewsListInteractor {


    fun execute(source: String): Flowable<List<NewsItem>?>

}