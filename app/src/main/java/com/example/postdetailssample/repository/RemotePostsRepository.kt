package com.example.postdetailssample.repository

import com.example.postdetailssample.model.SamplePost
import com.example.postdetailssample.service.ApiService
import com.example.postdetailssample.service.ApiServiceImpl
import javax.inject.Inject

class RemotePostsRepository @Inject constructor(
    private val apiService: ApiService
) : PostsRepository {

    override suspend fun loadPosts(): List<SamplePost> {
        return ApiResponseHandler.process(apiService.loadPosts())
    }

    override suspend fun loadPostDetails(id: Int): SamplePost {
        return ApiResponseHandler.process(apiService.loadPostDetails(id))
    }
}