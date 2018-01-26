package com.hilmanfatah.opennewsapi.presentation.source

import com.hilmanfatah.opennewsapi.domain.interactor.sources.GetNewsResourcesListInteractorImpl
import com.hilmanfatah.opennewsapi.domain.model.SourcesItem
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by hilmanfatah on 1/23/18.
 */
class SourcePresenterImpl : SourcePresenter {
    @Inject
    lateinit var getNewsResourcesListInteractor: GetNewsResourcesListInteractorImpl

    @Inject
    constructor()

    override fun getSourcesList(): Flowable<List<SourcesItem>?> =
            getNewsResourcesListInteractor
                    .execute("", "", "en")

}