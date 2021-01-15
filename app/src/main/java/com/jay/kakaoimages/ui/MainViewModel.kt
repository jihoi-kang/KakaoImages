package com.jay.kakaoimages.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jay.kakaoimages.api.KakaoService
import com.jay.kakaoimages.base.BaseViewModel
import com.jay.kakaoimages.model.Document
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val kakaoService: KakaoService
) : BaseViewModel() {

    var query = MutableLiveData<String>()

    private val _documentItems = MutableLiveData<List<Document>>()
    val documentItems: LiveData<List<Document>> get() = _documentItems

    fun search() {
        val query = query.value ?: return

        showLoading()
        kakaoService.getImages(query, 1, 30)
            .subscribeOn(Schedulers.io())
            .map { response -> response.documents }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ documents ->
                hideLoading()
                _documentItems.value = documents
            }, { error ->
                hideLoading()
                Log.e("TAG", "error: $error")
            }).addTo(disposable)
    }

}