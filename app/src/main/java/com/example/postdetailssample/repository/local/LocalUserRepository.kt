package com.example.postdetailssample.repository.local

import com.example.postdetailssample.model.SampleUser
import com.example.postdetailssample.repository.UserRepository
import com.example.postdetailssample.service.local.DatabaseService
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class LocalUserRepository @Inject constructor(
    private val databaseService: DatabaseService
) : UserRepository {

    override suspend fun loadUserDetails(userId: Int): SampleUser {
        return databaseService.loadUser(userId).first()
    }

    override suspend fun saveUserDetails(user: SampleUser) {
        return databaseService.insertUser(user)
    }
}