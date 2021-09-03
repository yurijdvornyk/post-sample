package com.example.postdetailssample.service

import com.example.postdetailssample.model.SamplePost
import com.example.postdetailssample.model.SampleUser
import retrofit2.Response

interface ApiService {
    suspend fun loadPosts(): Response<List<SamplePost>>

    suspend fun loadPostDetails(id: Int): Response<SamplePost>

    suspend fun loadUserDetails(userId: Int): Response<SampleUser>
}