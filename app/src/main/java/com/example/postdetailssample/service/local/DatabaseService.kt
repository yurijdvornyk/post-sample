package com.example.postdetailssample.service.local

import com.example.postdetailssample.model.SamplePost
import com.example.postdetailssample.model.SampleUser
import kotlinx.coroutines.flow.Flow

interface DatabaseService {

    fun loadPosts(): Flow<List<SamplePost>>

    fun loadPost(postId: Int) : Flow<SamplePost>

    fun loadUser(userId: Int): Flow<SampleUser>

    fun insertPosts(posts: List<SamplePost>)

    fun insertUser(user: SampleUser)
}