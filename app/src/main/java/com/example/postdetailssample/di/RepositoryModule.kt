package com.example.postdetailssample.di

import com.example.postdetailssample.repository.PostsRepository
import com.example.postdetailssample.repository.RemotePostsRepository
import com.example.postdetailssample.repository.RemoteUserRepository
import com.example.postdetailssample.repository.UserRepository
import com.example.postdetailssample.service.ApiService
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
    fun providesRemoteUserRepository(
        apiService: ApiService
    ): UserRepository {
        return RemoteUserRepository(apiService)
    }
}