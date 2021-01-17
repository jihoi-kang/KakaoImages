package com.jay.kakaoimages.ui.detail

import androidx.lifecycle.ViewModel
import com.jay.kakaoimages.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class DocumentDetailModule {

    @ContributesAndroidInjector
    internal abstract fun documentDetailActivity(): DocumentDetailActivity

    @Binds
    @IntoMap
    @ViewModelKey(DocumentDetailViewModel::class)
    abstract fun bindDocumentDetailViewModel(documentDetailViewModel: DocumentDetailViewModel): ViewModel

}