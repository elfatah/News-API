package com.hilmanfatah.opennewsapi.presentation.base.recyclerview

import android.content.Context
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.hilmanfatah.opennewsapi.R
import com.jakewharton.rxbinding.support.v7.widget.scrollEvents
import kotlinx.android.synthetic.main.refreshable_list.view.*


class RefreshableList : SwipeRefreshLayout {
    constructor(context: Context?) : super(context!!) {
        inflateContentView()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs) {
        inflateContentView()
    }

    private val layoutManager: LinearLayoutManager by lazy { LinearLayoutManager(context) }
    private val lastItemPosition: Int get() = recyclerView.adapter.itemCount - 1

    private var onLoadMoreListener: OnLoadMoreListener? = null

    fun showLoadingIndicator() {
        isRefreshing = true
    }

    fun hideLoadingIndicator() {
        isRefreshing = false
    }

    fun setOnLoadMoreListener(onLoadMoreListener: OnLoadMoreListener?) {
        this.onLoadMoreListener = onLoadMoreListener
    }

    private fun inflateContentView() {
        View.inflate(context, R.layout.refreshable_list, this)
        setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_green_light, android.R.color.holo_orange_light,
                android.R.color.holo_red_light)

        if (isInEditMode) return

        recyclerView.apply { layoutManager = this@RefreshableList.layoutManager }.setHasFixedSize(true)
        composeBinding()
    }

    fun setAsGrid(span: Int) {
        recyclerView.apply { layoutManager = GridLayoutManager(context, span) }.setHasFixedSize(true)

    }

    fun setAsList() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun hasLastItemInListReached() = layoutManager.findLastVisibleItemPosition() == lastItemPosition


    private fun composeBinding() {
        recyclerView.scrollEvents()
                .filter {
                    val result = it.view().childCount > 0 &&
                            hasLastItemInListReached() &&
                            !isRefreshing
                    result
                }.subscribe({
                    onLoadMoreListener?.onLoadMore()
                }, { Log.e("ERROR", "" + it.message) })


    }

    interface OnLoadMoreListener {
        fun onLoadMore()
    }
}