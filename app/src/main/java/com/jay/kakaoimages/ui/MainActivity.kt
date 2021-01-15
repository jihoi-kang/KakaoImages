package com.jay.kakaoimages.ui

import android.os.Bundle
import android.util.Log
import com.jay.kakaoimages.R
import com.jay.kakaoimages.api.KakaoService
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var kakaoService: KakaoService

    private val disposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kakaoService.getImages("test", 1, 30)
            .subscribeOn(Schedulers.io())
            .map { response ->
                response.documents
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ documents ->
                documents.forEach {
                    Log.e("TAG", "imageUrl : ${it.imageUrl}")
                }
            }, { error ->
                Log.e("TAG", "error: $error")
            }).addTo(disposable)
    }

    override fun onDestroy() {
        disposable.clear()
        super.onDestroy()
    }
}