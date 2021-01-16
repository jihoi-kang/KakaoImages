package com.jay.kakaoimages.ui

import android.os.Bundle
import com.jay.kakaoimages.R
import com.jay.kakaoimages.base.BaseActivity
import com.jay.kakaoimages.databinding.ActivityMainBinding
import com.jay.kakaoimages.ext.debounce

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    R.layout.activity_main,
    MainViewModel::class.java,
) {

    private val documentAdapter by lazy {
        DocumentAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupUi()
        setupObserve()
    }

    private fun setupUi() {
        binding.rvItemList.adapter = documentAdapter
    }

    private fun setupObserve() {
        viewModel.documentItems.observe(this) {
            documentAdapter.setDocuments(it)
        }

        viewModel.query.debounce(1000L).observe(this) {
            viewModel.load()
        }
    }

}