package com.jay.kakaoimages.ui

import androidx.recyclerview.widget.RecyclerView
import com.jay.kakaoimages.BR
import com.jay.kakaoimages.databinding.ItemDocumentBinding
import com.jay.kakaoimages.model.Document

class DocumentViewHolder(
    private val binding: ItemDocumentBinding,
    private val viewModel: MainViewModel,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(document: Document) {
        binding.setVariable(BR.item, document)
        binding.setVariable(BR.viewModel, viewModel)
        binding.executePendingBindings()
    }

}