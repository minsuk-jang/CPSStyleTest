package com.example.domain.repository

import com.example.domain.model.Document

interface RemoteRepository {
    suspend fun getSearchWebWithSuspendKeyword(query: String): List<Document>
}