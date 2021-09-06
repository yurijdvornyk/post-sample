package com.example.postdetailssample.service.local

import android.content.Context
import androidx.room.Room
import com.example.postdetailssample.model.SamplePost
import com.example.postdetailssample.model.SampleUser
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class DatabaseServiceImpl @Inject constructor(
    appContext: Context
) : DatabaseService {

    private val database = Room
        .databaseBuilder(appContext, SampleDatabase::class.java, "database.db")
        .build()

    override fun loadPosts(): Flow<List<SamplePost>> {
        return database.postDao().loadAll()
    }

    override fun loadPost(postId: Int): Flow<SamplePost> {
        return database.postDao().loadPost(postId)
    }

    override fun loadUser(userId: Int): Flow<SampleUser> {
        return database.userDao().loadUser(userId)
    }

    override fun insertPosts(posts: List<SamplePost>) {
        database.postDao().insertAll(posts)
    }

    override fun insertUser(user: SampleUser) {
        return database.userDao().insert(user)
    }
}