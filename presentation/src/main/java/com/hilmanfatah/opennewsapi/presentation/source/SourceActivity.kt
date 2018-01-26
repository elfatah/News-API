package com.hilmanfatah.opennewsapi.presentation.source

import android.os.Bundle
import android.view.View
import com.hilmanfatah.opennewsapi.NewsApplication
import com.hilmanfatah.opennewsapi.R
import com.hilmanfatah.opennewsapi.domain.model.SourcesItem
import com.hilmanfatah.opennewsapi.presentation.base.BaseActivity
import com.hilmanfatah.opennewsapi.presentation.base.adapter.BaseRecyclerViewAdapter
import com.hilmanfatah.opennewsapi.presentation.news.NewsListActivity
import com.hilmanfatah.opennewsapi.presentation.source.adapter.SourceListAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.refreshable_list.view.*
import javax.inject.Inject

class SourceActivity : BaseActivity() {

    @Inject
    lateinit var sourcePresenter: SourcePresenterImpl

    lateinit var sourceListAdapter: SourceListAdapter
    override fun getResourceLayout(): Int = R.layout.activity_main

    override fun onViewReady(savedInstanceState: Bundle?) {
        NewsApplication.applicationComponent.inject(this)
        setUpAdapter()
        setUpRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    private fun loadData() {
        sourcePresenter.getSourcesList()
                .compose(bindToLifecycle())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe { list.isRefreshing = true }
                .doOnTerminate { list.isRefreshing = false }
                .subscribe(this::setUpData)

    }

    private fun setUpData(sources: List<SourcesItem>?) {
        sources.let {
            if (it!!.isNotEmpty())
                sourceListAdapter.clearData()
            sourceListAdapter.addAllData(it)

        }
    }

    private fun setUpRecyclerView() {
        list.recyclerView.adapter = sourceListAdapter
        list.setOnRefreshListener { loadData() }

    }

    private fun setUpAdapter() {

        sourceListAdapter = SourceListAdapter(this)
        sourceListAdapter.mItemClickListener = object : BaseRecyclerViewAdapter.OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                startActivity(NewsListActivity.createIntent(this@SourceActivity, sourceListAdapter.mDatas[position].id!!, sourceListAdapter.mDatas[position].name!!))
            }

        }
    }


}
