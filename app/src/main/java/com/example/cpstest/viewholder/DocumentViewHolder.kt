package com.example.cpstest.viewholder

import android.view.View
import com.example.cpstest.base.BaseViewHolder
import com.example.cpstest.databinding.CellDocumentBinding
import com.example.cpstest.state.DocumentUiState

class DocumentViewHolder(private val view: View) :
    BaseViewHolder<CellDocumentBinding, DocumentUiState>(view) {
    override fun bind(item: DocumentUiState, position: Int) {
        super.bind(item, position)
        bind {
            state = item
            executePendingBindings()
        }
    }
}