package com.jay.kakaoimages.ext

import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.databinding.BindingAdapter

@BindingAdapter("navigationIconOnClick")
fun Toolbar.bindNavigationIconOnClick(listener: View.OnClickListener) {
    setNavigationOnClickListener(listener)
}