package com.hilmanfatah.opennewsapi.presentation.source

import android.view.View
import com.hilmanfatah.domain.model.SourcesItem
import com.hilmanfatah.opennewsapi.presentation.base.adapter.BaseRecyclerViewAdapter
import com.hilmanfatah.opennewsapi.presentation.base.adapter.viewholder.BaseItemViewHolder
import kotlinx.android.synthetic.main.source_item_view.view.*

/**
 * Created by hilmanfatah on 1/23/18.
 */
class SourceViewHolder(
        itemView: View,
        mItemClickListener: BaseRecyclerViewAdapter.OnItemClickListener?,
        mLongItemClickListener: BaseRecyclerViewAdapter.OnLongItemClickListener?)
    : BaseItemViewHolder<SourcesItem>(itemView, mItemClickListener, mLongItemClickListener), View.OnClickListener {


    override fun bind(data: SourcesItem, position: Int) {
        itemView.ivSource.setImageURI("http://lorempixel.com/400/200/technics/" + position)
        itemView.tvSourceDesc.text = data.description
        itemView.tvSourceTitle.text = data.name
        itemView.setOnClickListener { onClick(it) }
    }


}