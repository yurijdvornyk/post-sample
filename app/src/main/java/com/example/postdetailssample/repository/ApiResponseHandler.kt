package com.example.postdetailssample.repository

import android.accounts.NetworkErrorException
import retrofit2.HttpException
import retrofit2.Response

object ApiResponseHandler {

    fun <T> process(response: Response<T>): T {
        return if (response.isSuccessful) {
            response.body()?.let {
                return it
            } ?: throw NetworkErrorException("Response is null")
        } else {
            throw HttpException(response)
        }
    }
}