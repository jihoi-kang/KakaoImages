package com.jay.kakaoimages.di

import android.content.Context
import com.jay.kakaoimages.KakaoImagesApplication
import com.jay.kakaoimages.ui.main.MainModule
import com.jay.kakaoimages.ui.detail.DocumentDetailModule
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
        MainModule::class,
        DocumentDetailModule::class,
    ]
)
interface ApplicationComponent : AndroidInjector<KakaoImagesApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

}