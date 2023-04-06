package com.example.data.module

import com.example.data.repository.RemoteRepositoryImpl
import com.example.domain.repository.RemoteRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun getRemoteRepo(impl: RemoteRepositoryImpl): RemoteRepository
}