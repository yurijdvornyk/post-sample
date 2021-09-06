package com.example.postdetailssample.service.remote

import android.accounts.NetworkErrorException
import retrofit2.HttpException
import retrofit2.Response

object ApiResponseHandler {

    fun <T> process(response: Response<T>): T {
        return if (response.isSuccessful) {
            response.body() ?: throw NetworkErrorException("Response is null")
        } else {
            throw HttpException(response)
        }
    }
}