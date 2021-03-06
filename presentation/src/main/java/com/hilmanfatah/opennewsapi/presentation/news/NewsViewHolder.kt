package com.hilmanfatah.opennewsapi.presentation.news

import android.view.View
import com.hilmanfatah.domain.model.NewsItem
import com.hilmanfatah.opennewsapi.presentation.base.adapter.BaseRecyclerViewAdapter
import com.hilmanfatah.opennewsapi.presentation.base.adapter.viewholder.BaseItemViewHolder
import kotlinx.android.synthetic.main.news_item_view.view.*

/**
 * Created by Hilman N Fatah on 24/01/18.
 */
class NewsViewHolder(itemView: View,
                     mItemClickListener: BaseRecyclerViewAdapter.OnItemClickListener?,
                     mLongItemClickListener: BaseRecyclerViewAdapter.OnLongItemClickListener?)
    : BaseItemViewHolder<NewsItem>(itemView, mItemClickListener, mLongItemClickListener) {
    override fun bind(data: NewsItem, position: Int) {
        itemView.ivNews.setImageURI(data.urlToImage)
        itemView.tvDate.text = data.publishedAt
        itemView.tvNewsTitle.text = data.title
        itemView.tvNewsContent.text = data.description
        itemView.llNews.setOnClickListener { onClick(it) }

    }
}