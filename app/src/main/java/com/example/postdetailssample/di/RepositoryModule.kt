package com.example.postdetailssample.di

import com.example.postdetailssample.repository.PostsRepository
import com.example.postdetailssample.repository.remote.RemotePostsRepository
import com.example.postdetailssample.repository.remote.RemoteUserRepository
import com.example.postdetailssample.repository.UserRepository
import com.example.postdetailssample.repository.local.LocalPostsRepository
import com.example.postdetailssample.repository.local.LocalUserRepository
import com.example.postdetailssample.service.local.DatabaseService
import com.example.postdetailssample.service.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providesRemotePostsRepository(
        apiService: ApiService
    ): PostsRepository {
        return RemotePostsRepository(apiService)
    }

    @Singleton
    @Provides
    fun providesLocalPostsRepository(
        databaseService: DatabaseService
    ): PostsRepository {
        return LocalPostsRepository(databaseService)
    }

    @Singleton
    @Provides
    fun providesRemoteUserRepository(
        apiService: ApiService
    ): UserRepository {
        return RemoteUserRepository(apiService)
    }

    @Singleton
    @Provides
    fun providesLocalUserRepository(
        databaseService: DatabaseService
    ): UserRepository {
        return LocalUserRepository(databaseService)
    }
}