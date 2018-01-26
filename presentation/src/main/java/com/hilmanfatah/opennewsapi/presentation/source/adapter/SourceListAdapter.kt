package com.hilmanfatah.opennewsapi.presentation.source.adapter

import android.content.Context
import android.view.ViewGroup
import com.hilmanfatah.opennewsapi.R
import com.hilmanfatah.opennewsapi.domain.model.SourcesItem
import com.hilmanfatah.opennewsapi.presentation.base.adapter.BaseRecyclerViewAdapter
import com.hilmanfatah.opennewsapi.presentation.source.SourceViewHolder

/**
 * Created by hilmanfatah on 1/23/18.
 */

class SourceListAdapter(context: Context) : BaseRecyclerViewAdapter<SourcesItem, SourceViewHolder>(context) {
    override fun getItemResourceLayout(viewType: Int): Int = R.layout.source_item_view


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SourceViewHolder =
            SourceViewHolder(getView(parent!!, viewType), mItemClickListener, mLongItemClickListener)

}