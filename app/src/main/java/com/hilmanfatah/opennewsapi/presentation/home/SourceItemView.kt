package com.hilmanfatah.opennewsapi.presentation.home

import android.view.View
import com.hilmanfatah.opennewsapi.domain.model.SourcesItem
import com.hilmanfatah.opennewsapi.presentation.base.adapter.BaseRecyclerViewAdapter
import com.hilmanfatah.opennewsapi.presentation.base.adapter.viewholder.BaseItemViewHolder
import kotlinx.android.synthetic.main.source_item_view.view.*

/**
 * Created by hilmanfatah on 1/23/18.
 */
class SourceItemView(
        itemView: View,
        mItemClickListener: BaseRecyclerViewAdapter.OnItemClickListener?,
        mLongItemClickListener: BaseRecyclerViewAdapter.OnLongItemClickListener?)
    : BaseItemViewHolder<SourcesItem>(itemView, mItemClickListener, mLongItemClickListener) {


    override fun bind(data: SourcesItem, position: Int) {
        itemView.ivSource.setImageURI(data.urlsToLogos?.medium ?: "")
        itemView.tvSourceDesc.text = data.description
        itemView.tvSourceTitle.text = data.name
    }
}