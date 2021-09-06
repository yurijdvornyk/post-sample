package com.example.postdetailssample.service.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.postdetailssample.model.SampleUser
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM sampleUser WHERE sampleUser.id == :userId LIMIT 1")
    fun loadUser(userId: Int): Flow<SampleUser>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: SampleUser)
}