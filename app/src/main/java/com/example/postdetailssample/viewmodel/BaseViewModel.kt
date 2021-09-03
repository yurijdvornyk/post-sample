package com.example.postdetailssample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    val errorMessageData: LiveData<String>
        get() = internalErrorMessageData

    protected val internalErrorMessageData = MutableLiveData<String>()
}