package com.jay.kakaoimages.di

import com.jay.kakaoimages.data.KakaoImageRemoteDataSource
import com.jay.kakaoimages.data.KakaoImageRemoteDataSourceImpl
import com.jay.kakaoimages.data.KakaoImageRepository
import com.jay.kakaoimages.data.KakaoImageRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindKakaoImageRepository(shoppingRepositoryImpl: KakaoImageRepositoryImpl): KakaoImageRepository

    @Binds
    abstract fun bindKakaoImageRemoteDataSource(shoppingRemoteDataSourceImpl: KakaoImageRemoteDataSourceImpl): KakaoImageRemoteDataSource

}