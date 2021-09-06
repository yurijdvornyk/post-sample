package com.example.postdetailssample.repository

import com.example.postdetailssample.model.SampleUser

interface UserRepository {
    suspend fun loadUserDetails(userId: Int): SampleUser

    suspend fun saveUserDetails(user: SampleUser)
}