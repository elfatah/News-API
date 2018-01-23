package com.hilmanfatah.opennewsapi.presentation.home

import android.os.Bundle
import com.hilmanfatah.opennewsapi.NewsApplication
import com.hilmanfatah.opennewsapi.R
import com.hilmanfatah.opennewsapi.domain.model.SourcesItem
import com.hilmanfatah.opennewsapi.presentation.base.BaseActivity
import com.hilmanfatah.opennewsapi.presentation.home.adapter.SourceListAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.refreshable_list.view.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var homePresenter: HomePresenterImpl

    lateinit var sourceListAdapter: SourceListAdapter
    override fun getResourceLayout(): Int = R.layout.activity_main

    override fun onViewReady(savedInstanceState: Bundle?) {
        NewsApplication.applicationComponent.inject(this)
        setUpAdapter()
        setUpRecyclerView()
        loadData()
    }

    private fun loadData() {
        homePresenter.getSourcesList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe { list.isRefreshing = true }
                .doOnTerminate { list.isRefreshing = false }
                .subscribe(this::setUpData)

    }

    private fun setUpData(sources: List<SourcesItem>?) {
        sources.let {
            if (it!!.isNotEmpty())
                sourceListAdapter.addAllData(it)

        }
    }

    private fun setUpRecyclerView() {
        list.recyclerView.adapter = sourceListAdapter
        list.setOnRefreshListener { loadData() }

    }

    private fun setUpAdapter() {

        sourceListAdapter = SourceListAdapter(this)
    }


}
