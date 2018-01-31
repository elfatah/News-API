package com.hilmanfatah.opennewsapi.presentation.base.adapter.viewholder

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import com.hilmanfatah.opennewsapi.presentation.base.adapter.BaseRecyclerViewAdapter


abstract class BaseItemViewHolder<in Data>(
        itemView: View,
        private val mItemClickListener: BaseRecyclerViewAdapter.OnItemClickListener?,
        private val mLongItemClickListener: BaseRecyclerViewAdapter.OnLongItemClickListener?
) : RecyclerView.ViewHolder(itemView), View.OnClickListener, View.OnLongClickListener {

    protected var mContext: Context = itemView.context


    abstract fun bind(data: Data, position: Int)

    override fun onClick(p0: View?) {
        mItemClickListener?.onItemClick(p0!!, adapterPosition)
    }

    override fun onLongClick(p0: View?): Boolean {
        mLongItemClickListener?.onLongItemClick(p0!!, adapterPosition)
        return true
    }

}