package com.hilmanfatah.opennewsapi.presentation.news.adapter

import android.content.Context
import android.view.ViewGroup
import com.hilmanfatah.opennewsapi.R
import com.hilmanfatah.opennewsapi.domain.model.NewsItem
import com.hilmanfatah.opennewsapi.presentation.base.adapter.BaseRecyclerViewAdapter
import com.hilmanfatah.opennewsapi.presentation.news.NewsViewHolder

/**
 * Created by Hilman N Fatah on 24/01/18.
 */
class NewsListAdapter(context: Context) : BaseRecyclerViewAdapter<NewsItem, NewsViewHolder>(context) {
    override fun getItemResourceLayout(viewType: Int): Int = R.layout.news_item_view

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NewsViewHolder = NewsViewHolder(getView(parent!!, viewType), mItemClickListener, mLongItemClickListener)
}