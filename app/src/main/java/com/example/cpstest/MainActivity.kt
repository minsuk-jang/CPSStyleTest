package com.example.cpstest

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cpstest.adapter.DocumentAdapter
import com.example.cpstest.base.BaseActivity
import com.example.cpstest.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
@ActivityScoped
class MainActivity :
    BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val vm: MainActivityViewModel by viewModels()

    @Inject
    lateinit var adapter: DocumentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindRecyclerView()
        search(query = "윌라")

        observeLifecycle()
    }

    private fun bindRecyclerView() {
        bind {
            with(recyclerView) {
                adapter = this@MainActivity.adapter
                layoutManager = LinearLayoutManager(context)

                itemAnimator = null
                stateListAnimator = null
            }
        }
    }

    private fun search(query: String) {
        vm.getSearchWeb(query = query)
    }

    private fun observeLifecycle() {
        lifecycleScope.launch {
            vm.result.collectLatest {
                adapter.submitList(it)
            }
        }
    }
}