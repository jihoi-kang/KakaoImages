package com.jay.kakaoimages.data

import com.jay.kakaoimages.model.Document
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class KakaoImageRepositoryImpl @Inject constructor(
    private val kakaoImageRemoteDataSource: KakaoImageRemoteDataSource,
) : KakaoImageRepository {

    override fun getImages(query: String, page: Int): Single<List<Document>> {
        return kakaoImageRemoteDataSource.getImages(query, page)
            .subscribeOn(Schedulers.io())
            .map { it.documents }
    }

}