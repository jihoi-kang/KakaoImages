package com.jay.kakaoimages.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.jay.kakaoimages.BR
import com.jay.kakaoimages.R
import com.jay.kakaoimages.base.BaseActivity
import com.jay.kakaoimages.databinding.ActivityDocumentDetailBinding
import com.jay.kakaoimages.model.Document

class DocumentDetailActivity : BaseActivity<ActivityDocumentDetailBinding, DocumentDetailViewModel>(
    R.layout.activity_document_detail,
    DocumentDetailViewModel::class.java,
) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupUi()
        setupObserve()
    }

    private fun setupUi() {
        val document = intent.getParcelableExtra<Document>(EXTRA_DOCUMENT)
        binding.setVariable(BR.item, document)
    }

    private fun setupObserve() {
        viewModel.closeEvent.observe(this) {
            finish()
        }
    }

    companion object {

        private const val EXTRA_DOCUMENT = "android.intent.extra.DOCUMENT"

        fun getIntent(context: Context, document: Document) =
            Intent(context, DocumentDetailActivity::class.java).apply {
                putExtra(EXTRA_DOCUMENT, document)
            }

    }

}