package com.jay.kakaoimages.data

import com.jay.kakaoimages.api.GetImagesResponse
import io.reactivex.Single

interface KakaoImageRemoteDataSource {

    fun getImages(query: String, page: Int): Single<GetImagesResponse>

}