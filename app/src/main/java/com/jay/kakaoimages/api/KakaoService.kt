package com.jay.kakaoimages.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface KakaoService {

    @GET("/v2/search/image")
    fun getImages(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("size") size: Int,
    ): Single<GetImagesResponse>

}