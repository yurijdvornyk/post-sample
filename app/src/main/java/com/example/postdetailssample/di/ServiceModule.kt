package com.example.postdetailssample.di

import com.example.postdetailssample.service.ApiService
import com.example.postdetailssample.service.ApiServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Singleton
    @Provides
    fun provideApiService(): ApiService {
        return ApiServiceImpl()
    }
}