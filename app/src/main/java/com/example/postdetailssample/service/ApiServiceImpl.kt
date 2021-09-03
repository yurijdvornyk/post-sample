package com.example.postdetailssample.service

import com.example.postdetailssample.model.SamplePost
import com.example.postdetailssample.model.SampleUser
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ApiServiceImpl @Inject constructor() : ApiService {
    private val retrofit = Retrofit
        .Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(SampleRetrofitService::class.java)

    override suspend fun loadPosts(): Response<List<SamplePost>> {
        return service.loadPosts()
    }

    override suspend fun loadPostDetails(id: Int): Response<SamplePost> {
        return service.loadPostDetails(id)
    }

    override suspend fun loadUserDetails(userId: Int): Response<SampleUser> {
        return service.loadUserDetails(userId)
    }
}