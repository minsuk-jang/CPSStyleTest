package com.example.domain.usecase

import com.example.domain.model.Document
import com.example.domain.repository.RemoteRepository
import dagger.Reusable
import javax.inject.Inject

@Reusable
class GetWebResultDocumentList @Inject constructor(
    private val repository: RemoteRepository
) {
    suspend operator fun invoke(query: String): List<Document> {
        return repository.getSearchWebWithSuspendKeyword(query = query)
    }
}