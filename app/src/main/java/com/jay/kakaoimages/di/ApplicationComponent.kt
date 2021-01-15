package com.jay.kakaoimages.di

import android.content.Context
import com.jay.kakaoimages.KakaoImagesApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
    ]
)
interface ApplicationComponent : AndroidInjector<KakaoImagesApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

}