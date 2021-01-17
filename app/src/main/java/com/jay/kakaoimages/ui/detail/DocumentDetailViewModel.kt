package com.jay.kakaoimages.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jay.kakaoimages.base.BaseViewModel
import javax.inject.Inject

class DocumentDetailViewModel @Inject constructor() : BaseViewModel() {

    private val _closeEvent = MutableLiveData<Unit>()
    val closeEvent: LiveData<Unit> get() = _closeEvent

    fun close() {
        _closeEvent.value = Unit
    }

}