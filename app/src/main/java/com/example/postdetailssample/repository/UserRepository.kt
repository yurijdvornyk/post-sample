package com.example.postdetailssample.repository

import com.example.postdetailssample.model.SampleUser

interface UserRepository {
    suspend fun loadUserDetails(id: Int): SampleUser
}