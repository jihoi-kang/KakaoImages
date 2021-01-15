package com.jay.kakaoimages.di

import com.jay.kakaoimages.BuildConfig
import com.jay.kakaoimages.api.KakaoService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                chain.proceed(
                    chain.request().newBuilder()
                        .addHeader("Authorization", "KakaoAK ${BuildConfig.REST_API_KEY}")
                        .build()
                )
            }.build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideKakaoService(
        retrofit: Retrofit
    ): KakaoService = retrofit.create(KakaoService::class.java)

    companion object {
        private const val BASE_URL = "https://dapi.kakao.com/"
    }

}