package com.example.postdetailssample.repository.remote

import com.example.postdetailssample.model.SamplePost
import com.example.postdetailssample.service.remote.ApiResponseHandler
import com.example.postdetailssample.repository.PostsRepository
import com.example.postdetailssample.service.remote.ApiService
import javax.inject.Inject

class RemotePostsRepository @Inject constructor(
    private val apiService: ApiService
) : PostsRepository {

    override suspend fun loadPosts(): List<SamplePost> {
        return ApiResponseHandler.process(apiService.loadPosts())
    }

    override suspend fun loadPostDetails(postId: Int): SamplePost {
        return ApiResponseHandler.process(apiService.loadPostDetails(postId))
    }

    override suspend fun savePosts(posts: List<SamplePost>) {
    }
}