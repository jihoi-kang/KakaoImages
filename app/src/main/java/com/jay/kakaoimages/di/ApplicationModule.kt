package com.jay.kakaoimages.di

import dagger.Module

@Module(
    includes = [
        NetworkModule::class,
    ]
)
class ApplicationModule