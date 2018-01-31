package com.hilmanfatah.opennewsapi.presentation.news

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.hilmanfatah.domain.model.NewsItem
import com.hilmanfatah.opennewsapi.NewsApplication
import com.hilmanfatah.opennewsapi.R
import com.hilmanfatah.opennewsapi.presentation.base.BaseActivity
import com.hilmanfatah.opennewsapi.presentation.base.adapter.BaseRecyclerViewAdapter
import com.hilmanfatah.opennewsapi.presentation.news.adapter.NewsListAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_news_list.*
import kotlinx.android.synthetic.main.refreshable_list.view.*
import javax.inject.Inject

class NewsListActivity : BaseActivity() {

    private var sourceName = ""
    private var descSource = ""

    @Inject
    lateinit var newsPresenter: NewsPresenterImpl

    lateinit var newsListAdapter: NewsListAdapter

    companion object {
        private val ARG_SOURCE = "ARG_SOURCE"
        private val ARG_SOURCE_NAME = "ARG_SOURCE_NAME"


        fun createIntent(context: Context, source: String, sourceDesc: String): Intent {
            return Intent(context, NewsListActivity::class.java).putExtra(ARG_SOURCE, source)
                    .putExtra(ARG_SOURCE_NAME, sourceDesc)
        }
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    override fun getResourceLayout(): Int = R.layout.activity_news_list

    override fun onViewReady(savedInstanceState: Bundle?) {
        NewsApplication.applicationComponent.inject(this)
        descSource = intent.getStringExtra(ARG_SOURCE_NAME)
        sourceName = intent.getStringExtra(ARG_SOURCE)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = descSource
        setUpAdapter()
        setUpRecyclerView()
    }

    fun loadData() {
        newsPresenter.getArticles(sourceName)
                .compose(bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { list.isRefreshing = true }
                .doOnTerminate { list.isRefreshing = false }
                .subscribe(this::setUpData)

    }

    private fun setUpData(articles: List<NewsItem>?) {
        articles.let {
            if (it!!.isNotEmpty())
                newsListAdapter.clearData()
            newsListAdapter.addAllData(it)

        }
    }

    private fun setUpRecyclerView() {
        list.recyclerView.adapter = newsListAdapter
        list.setOnRefreshListener { loadData() }

    }

    private fun setUpAdapter() {
        newsListAdapter = NewsListAdapter(this)
        newsListAdapter.mItemClickListener = object : BaseRecyclerViewAdapter.OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                startActivity(NewsDetailActivity.createIntent(this@NewsListActivity, newsListAdapter.mDatas[position].url!!, newsListAdapter.mDatas[position].title!!))

            }

        }

    }

    override fun onBackPressed() {
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
