package com.example.postdetailssample.repository

import com.example.postdetailssample.model.SamplePost

interface PostsRepository {

    suspend fun loadPosts(): List<SamplePost>

    suspend fun loadPostDetails(postId: Int): SamplePost

    suspend fun savePosts(posts: List<SamplePost>)
}