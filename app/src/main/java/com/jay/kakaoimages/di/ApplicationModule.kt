package com.jay.kakaoimages.di

import dagger.Module

@Module(
    includes = [
        NetworkModule::class,
        RepositoryModule::class,
    ]
)
class ApplicationModule