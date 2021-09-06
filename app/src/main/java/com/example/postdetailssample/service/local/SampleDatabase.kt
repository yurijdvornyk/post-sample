package com.example.postdetailssample.service.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.postdetailssample.model.*
import com.example.postdetailssample.service.local.dao.PostDao
import com.example.postdetailssample.service.local.dao.UserDao

@Database(
    entities = [
        SamplePost::class,
        SampleUser::class
    ],
    version = 1
)

abstract class SampleDatabase : RoomDatabase() {

    abstract fun postDao(): PostDao

    abstract fun userDao(): UserDao
}