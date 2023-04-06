package com.example.cpstest

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cpstest.state.DocumentUiState
import com.example.domain.model.Document
import com.example.domain.usecase.GetWebResultDocumentList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.logging.Logger
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getWebResultDocumentList: GetWebResultDocumentList
) : ViewModel() {
    private val _result = MutableStateFlow<List<DocumentUiState>>(emptyList())
    val result: StateFlow<List<DocumentUiState>> = _result.asStateFlow()

    fun getSearchWeb(query: String) {
        viewModelScope.launch {
            _result.update {
                getWebResultDocumentList(query = query).map {
                    DocumentUiState(
                        title = it.title,
                        url = it.url,
                        contents = it.contents,
                        datetime = it.datetime
                    )
                }
            }
        }
    }
}