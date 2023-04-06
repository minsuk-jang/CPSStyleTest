package com.example.cpstest.base

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T : ViewDataBinding, State : Any>(private val view: View) :
    RecyclerView.ViewHolder(view) {
    private var _binding = DataBindingUtil.bind<T>(view)
    protected val binding get() = _binding!!
    protected lateinit var item: State

    open fun bind(item: State, position: Int) {
        this.item = item
    }

    protected fun bind(block: T.() -> Unit) {
        block(binding)
    }
}