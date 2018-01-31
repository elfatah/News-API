package com.hilmanfatah.opennewsapi.presentation.news

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.hilmanfatah.opennewsapi.R
import com.hilmanfatah.opennewsapi.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_news_detail.*

class NewsDetailActivity : BaseActivity() {

    var newsUrl = ""
    var newsTitle = ""

    companion object {
        private val ARG_NEWS_URL = "ARG_NEWS_URL"
        private val ARG_NEWS_TITLE = "ARG_NEWS_TITLE"

        fun createIntent(context: Context, url: String, title: String): Intent {
            return Intent(context, NewsDetailActivity::class.java).putExtra(ARG_NEWS_URL, url)
                    .putExtra(ARG_NEWS_TITLE, title)

        }
    }


    override fun getResourceLayout(): Int = R.layout.activity_news_detail

    override fun onViewReady(savedInstanceState: Bundle?) {
        newsUrl = intent.getStringExtra(ARG_NEWS_URL)
        newsTitle = intent.getStringExtra(ARG_NEWS_TITLE)
        supportActionBar?.title = newsTitle
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initView()
        loadNews()
    }

    private fun loadNews() {

        wvNews.loadUrl(newsUrl)

    }

    private fun initView() {
        wvNews.settings.defaultFontSize = 14
        wvNews.settings.loadWithOverviewMode = true
        wvNews.settings.useWideViewPort = true
        wvNews.setBackgroundColor(Color.TRANSPARENT)
        wvNews.settings.javaScriptCanOpenWindowsAutomatically = true
        wvNews.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                swipe.isRefreshing = true

            }

            override fun onPageFinished(view: WebView?, url: String?) {
                swipe.isRefreshing = false

            }

        }

        swipe.setOnRefreshListener { loadNews() }

    }

    override fun onBackPressed() {
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}
