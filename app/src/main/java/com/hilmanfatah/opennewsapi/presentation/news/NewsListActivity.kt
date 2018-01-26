package com.hilmanfatah.opennewsapi.presentation.news

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.hilmanfatah.opennewsapi.NewsApplication
import com.hilmanfatah.opennewsapi.R
import com.hilmanfatah.opennewsapi.domain.model.ArticlesItem
import com.hilmanfatah.opennewsapi.presentation.base.BaseActivity
import com.hilmanfatah.opennewsapi.presentation.news.adapter.ArticleListAdapter
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

    lateinit var articleListAdapter: ArticleListAdapter

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
                .subscribe(this::setUpData)

    }

    private fun setUpData(articles: List<ArticlesItem>?) {
        articles.let {
            if (it!!.isNotEmpty())
                articleListAdapter.clearData()
            articleListAdapter.addAllData(it)

        }
    }

    private fun setUpRecyclerView() {
        list.recyclerView.adapter = articleListAdapter

    }

    private fun setUpAdapter() {
        articleListAdapter = ArticleListAdapter(this)

    }

    override fun onBackPressed() {
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
