package com.hilmanfatah.opennewsapi.presentation.base.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hilmanfatah.opennewsapi.presentation.base.adapter.viewholder.BaseItemViewHolder


abstract class BaseRecyclerViewAdapter<Data, Holder : BaseItemViewHolder<Data>>(private val context: Context) : RecyclerView.Adapter<Holder>() {
    private val mContext = this.context
    var mDatas: ArrayList<Data> = ArrayList()
    var mItemClickListener: OnItemClickListener? = null
    var mLongItemClickListener: OnLongItemClickListener? = null

    protected fun getView(parent: ViewGroup, viewType: Int): View =
            LayoutInflater.from(mContext).inflate(getItemResourceLayout(viewType = viewType), parent, false)


    protected abstract fun getItemResourceLayout(viewType: Int): Int

    override abstract fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder

    override fun onBindViewHolder(holder: Holder, position: Int) =
            holder.bind(mDatas[position], position)


    override fun getItemCount(): Int = mDatas.size

    override fun getItemId(position: Int): Long = position.toLong()

    fun addAllData(dataList: List<Data>) {
        mDatas.addAll(dataList)
        notifyDataSetChanged()

    }

    fun addData(data: Data) {
        mDatas.add(data)
        notifyDataSetChanged()
    }

    fun addData(dataList: List<Data>) {
        for (data in dataList)
            addData(data)
    }

    fun clearData() {
        mDatas.clear()
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    interface OnLongItemClickListener {
        fun onLongItemClick(view: View, position: Int)
    }

    interface OnLoadMoreListener {
        fun onLoadMore()
    }

    private fun isFooter(position: Int): Boolean = position == itemCount - 1


}