package com.example.postdetailssample.service

import com.example.postdetailssample.model.SamplePost
import com.example.postdetailssample.model.SampleUser
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SampleRetrofitService {

    @GET("posts")
    suspend fun loadPosts(): Response<List<SamplePost>>

    @GET("posts/{id}")
    suspend fun loadPostDetails(@Path("id") id: Int): Response<SamplePost>

    @GET("users/{id}")
    suspend fun loadUserDetails(@Path("id") id: Int): Response<SampleUser>
}