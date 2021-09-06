package com.example.postdetailssample.di

import android.content.Context
import com.example.postdetailssample.service.remote.ApiService
import com.example.postdetailssample.service.remote.ApiServiceImpl
import com.example.postdetailssample.service.local.DatabaseService
import com.example.postdetailssample.service.local.DatabaseServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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

    @Singleton
    @Provides
    fun provideDatabaseService(@ApplicationContext context: Context): DatabaseService {
        return DatabaseServiceImpl(context)
    }
}