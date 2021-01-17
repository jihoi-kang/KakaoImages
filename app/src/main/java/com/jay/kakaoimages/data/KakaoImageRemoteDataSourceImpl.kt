package com.jay.kakaoimages.data

import com.jay.kakaoimages.api.GetImagesResponse
import com.jay.kakaoimages.api.KakaoService
import io.reactivex.Single
import javax.inject.Inject

class KakaoImageRemoteDataSourceImpl @Inject constructor(
    private val kakaoService: KakaoService,
) : KakaoImageRemoteDataSource {

    override fun getImages(query: String, page: Int): Single<GetImagesResponse> =
        kakaoService.getImages(query, page)

}