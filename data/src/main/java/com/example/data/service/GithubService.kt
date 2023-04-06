package com.example.data.service

import com.example.data.dto.PayLoadDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {
    @GET("v2/search/web")
    suspend fun getSearchWebWithSuspendKeyword(
        @Query("query") query: String
    ): PayLoadDto
}