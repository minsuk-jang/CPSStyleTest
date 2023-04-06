package com.example.data.module

import com.example.data.service.GithubService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    fun getGithubService(
        retrofit: Retrofit
    ): GithubService {
        return retrofit.create(GithubService::class.java)
    }
}