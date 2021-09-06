package com.example.postdetailssample.repository

import com.example.postdetailssample.model.SampleUser
import com.example.postdetailssample.service.remote.ApiService
import javax.inject.Inject

class RemoteUserRepository @Inject constructor(
    private val apiService: ApiService
) : UserRepository {

    override suspend fun loadUserDetails(id: Int): SampleUser {
        return ApiResponseHandler.process(apiService.loadUserDetails(id))
    }

    override suspend fun saveUserDetails(user: SampleUser) {
    }
}