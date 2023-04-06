package com.example.data.repository

import com.example.data.mapper.toDocumentModel
import com.example.data.source.RemoteDataSource
import com.example.domain.model.Document
import com.example.domain.repository.RemoteRepository
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : RemoteRepository {
    override suspend fun getSearchWebWithSuspendKeyword(query: String): List<Document> {
        return remoteDataSource.getSearchWebWithSuspendKeyword(query = query).documents?.map {
            it.toDocumentModel()
        } ?: emptyList()
    }
}