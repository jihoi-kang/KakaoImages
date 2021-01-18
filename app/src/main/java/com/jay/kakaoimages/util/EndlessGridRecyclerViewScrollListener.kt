package com.jay.kakaoimages.util

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class EndlessGridRecyclerViewScrollListener(
    private val layoutManager: GridLayoutManager,
    private val threshold: Int = 3,
) : RecyclerView.OnScrollListener() {

    private var previousTotalItemCount = 0
    private var loading = true

    abstract fun onLoadMore()

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        val totalItemCount = layoutManager.itemCount
        val threshold = threshold * layoutManager.spanCount
        val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()

        if (totalItemCount < previousTotalItemCount) {
            previousTotalItemCount = totalItemCount
            if (totalItemCount == 0) {
                loading = true
            }
        }

        if (loading && totalItemCount > previousTotalItemCount) {
            loading = false
            previousTotalItemCount = totalItemCount
        }

        if (!loading && lastVisibleItemPosition + threshold > totalItemCount) {
            loading = true
            onLoadMore()
        }
    }

    fun resetState() {
        this.previousTotalItemCount = 0
        this.loading = true
    }

}