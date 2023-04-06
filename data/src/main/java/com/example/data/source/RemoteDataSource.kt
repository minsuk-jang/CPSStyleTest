package com.example.data.source

import com.example.data.dto.PayLoadDto
import com.example.data.service.GithubService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(
    private val githubService: GithubService
) {
    suspend fun getSearchWebWithSuspendKeyword(query: String) : PayLoadDto{
        return githubService.getSearchWebWithSuspendKeyword(query = query)
    }
}