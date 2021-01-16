package com.jay.kakaoimages.ext

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jay.kakaoimages.util.EndlessGridRecyclerViewScrollListener

@BindingAdapter("onLoad", "threshold", requireAll = false)
fun RecyclerView.bindLoadMore(
    onLoad: (() -> Unit)? = null,
    threshold: Int? = null,
) {
    onLoad ?: return
    threshold ?: return
    val layoutManager = layoutManager ?: return

    if (layoutManager is GridLayoutManager) {
        addOnScrollListener(
            EndlessGridRecyclerViewScrollListener(layoutManager, threshold, onLoad)
        )
    }
}