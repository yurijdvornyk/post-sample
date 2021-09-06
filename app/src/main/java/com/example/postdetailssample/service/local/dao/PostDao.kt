package com.example.postdetailssample.service.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.postdetailssample.model.SamplePost
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {
    @Query("SELECT * FROM samplePost")
    fun loadAll(): Flow<List<SamplePost>>

    @Query("SELECT * FROM samplePost WHERE samplePost.id == :postId LIMIT 1")
    fun loadPost(postId: Int): Flow<SamplePost>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(posts: List<SamplePost>)
}