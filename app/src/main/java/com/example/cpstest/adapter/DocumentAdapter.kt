package com.example.cpstest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.cpstest.R
import com.example.cpstest.state.DocumentUiState
import com.example.cpstest.viewholder.DocumentViewHolder
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class DocumentAdapter @Inject constructor() : ListAdapter<DocumentUiState, DocumentViewHolder>(
    diff
) {
    companion object {
        val diff = object : DiffUtil.ItemCallback<DocumentUiState>() {
            override fun areItemsTheSame(
                oldItem: DocumentUiState,
                newItem: DocumentUiState
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: DocumentUiState,
                newItem: DocumentUiState
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocumentViewHolder {
        return DocumentViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.cell_document, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DocumentViewHolder, position: Int) {
        holder.bind(item = getItem(position), position = position)
    }
}