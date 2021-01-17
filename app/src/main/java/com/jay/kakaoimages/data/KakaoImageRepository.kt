package com.jay.kakaoimages.data

import com.jay.kakaoimages.model.Document
import io.reactivex.Single

interface KakaoImageRepository {

    fun getImages(query: String, page: Int): Single<List<Document>>

}