package com.jay.kakaoimages.ui.main

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.jay.kakaoimages.R
import com.jay.kakaoimages.api.UNKNOWN_ERROR
import com.jay.kakaoimages.base.BaseActivity
import com.jay.kakaoimages.databinding.ActivityMainBinding
import com.jay.kakaoimages.ext.debounce
import com.jay.kakaoimages.ui.detail.DocumentDetailActivity
import com.jay.kakaoimages.util.eventObserve

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    R.layout.activity_main,
    MainViewModel::class.java,
) {

    private val documentAdapter by lazy {
        DocumentAdapter(viewModel)
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

        viewModel.openDetailEvent.eventObserve(this) {
            startActivity(DocumentDetailActivity.getIntent(this, it))
        }

        viewModel.errorPopupEvent.eventObserve(this) { message ->
            showPopup(
                if (message == UNKNOWN_ERROR) getString(R.string.msg_unknown_error)
                else message
            )
        }
    }

    private fun showPopup(message: String) {
        AlertDialog.Builder(this)
            .setMessage(message)
            .setPositiveButton(getString(R.string.text_okay)) { dialog, _ ->
                dialog.dismiss()
            }.show()

    }

}