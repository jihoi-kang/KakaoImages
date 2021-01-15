package com.jay.kakaoimages.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jay.kakaoimages.R
import com.jay.kakaoimages.databinding.ItemDocumentBinding
import com.jay.kakaoimages.model.Document

class DocumentAdapter : RecyclerView.Adapter<DocumentViewHolder>() {

    private val documentItems: MutableList<Document> = mutableListOf()

    fun setDocuments(documentItems: List<Document>) {
        this.documentItems.clear()
        this.documentItems.addAll(documentItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocumentViewHolder {
        val binding = DataBindingUtil.inflate<ItemDocumentBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_document,
            parent,
            false
        )
        return DocumentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DocumentViewHolder, position: Int) {
        holder.bind(documentItems[position])
    }

    override fun getItemCount(): Int = documentItems.size

}