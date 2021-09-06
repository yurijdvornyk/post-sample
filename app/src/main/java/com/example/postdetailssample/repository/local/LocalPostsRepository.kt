package com.example.postdetailssample.repository.local

import com.example.postdetailssample.model.SamplePost
import com.example.postdetailssample.repository.PostsRepository
import com.example.postdetailssample.service.local.DatabaseService
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class LocalPostsRepository @Inject constructor(
    private val databaseService: DatabaseService
) : PostsRepository {

    override suspend fun loadPosts(): List<SamplePost> {
        return databaseService.loadPosts().first()
    }

    override suspend fun loadPostDetails(postId: Int): SamplePost {
        return databaseService.loadPost(postId).first()
    }

    override suspend fun savePosts(posts: List<SamplePost>) {
        return databaseService.insertPosts(posts)
    }
}