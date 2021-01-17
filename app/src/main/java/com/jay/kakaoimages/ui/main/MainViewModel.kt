package com.jay.kakaoimages.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jay.kakaoimages.api.asErrorResponse
import com.jay.kakaoimages.base.BaseViewModel
import com.jay.kakaoimages.data.KakaoImageRepository
import com.jay.kakaoimages.model.Document
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val kakaoImageRepository: KakaoImageRepository
) : BaseViewModel() {

    var query = MutableLiveData<String>()

    private val _documentItems = MutableLiveData<MutableList<Document>>(mutableListOf())
    val documentItems: LiveData<MutableList<Document>> get() = _documentItems

    private val _openDetailEvent = MutableLiveData<Document>()
    val openDetailEvent: LiveData<Document> get() = _openDetailEvent

    private val _errorPopupEvent = MutableLiveData<String>()
    val errorPopupEvent: LiveData<String> get() = _errorPopupEvent

    private var page = 1

    fun load() {
        val query = query.value ?: return
        if (query.isEmpty()) {
            _documentItems.value = mutableListOf()
            return
        }

        page = 1
        showLoading()
        kakaoImageRepository.getImages(query, page)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ documents ->
                page++
                hideLoading()

                val list = mutableListOf<Document>()
                list.addAll(documents)
                _documentItems.value = list
            }, { error ->
                hideLoading()
                _errorPopupEvent.value = error.asErrorResponse().message
            }).addTo(disposable)
    }

    fun loadMore() {
        val query = query.value ?: return

        showLoading()
        kakaoImageRepository.getImages(query, page)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ documents ->
                page++
                hideLoading()
                _documentItems.value = _documentItems.value?.apply {
                    addAll(documents)
                }
            }, { error ->
                hideLoading()
                _errorPopupEvent.value = error.asErrorResponse().message
            }).addTo(disposable)
    }

    fun openDocumentDetail(document: Document) {
        _openDetailEvent.value = document
    }

}