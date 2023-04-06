package com.example.cpstest.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T : ViewDataBinding>(@LayoutRes private val layoutId: Int) :
    AppCompatActivity() {
    private var _binding: T? = null
    protected val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView<T>(this, layoutId).apply {
            lifecycleOwner = this@BaseActivity
        }

        setContentView(binding.root)
    }

    protected fun bind(block: T.() -> Unit) {
        block(binding)
    }
}