package com.example.postdetailssample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.postdetailssample.model.SamplePost
import com.example.postdetailssample.model.SampleUser
import com.example.postdetailssample.repository.RemotePostsRepository
import com.example.postdetailssample.repository.RemoteUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostDetailsViewModel @Inject constructor(
    private val remotePostsRepository: RemotePostsRepository,
    private val remoteUserRepository: RemoteUserRepository
) :
    BaseViewModel() {

    val postData: LiveData<SamplePost>
        get() = internalPostData

    private val internalUserData = MutableLiveData<SampleUser>()

    val userData: LiveData<SampleUser>
        get() = internalUserData

    private val internalPostData = MutableLiveData<SamplePost>()

    private var postId: Int? = null

    fun loadData() {
        postId?.let {
            viewModelScope.launch {
                try {
                    val postDetails = remotePostsRepository.loadPostDetails(it)
                    val userDetails = remoteUserRepository.loadUserDetails(postDetails.userId)
                    internalPostData.postValue(postDetails)
                    internalUserData.postValue(userDetails)
                } catch (e: Exception) {
                    internalErrorMessageData.postValue(e.message)
                }
            }
        }
    }

    fun initialize(postId: Int?) {
        this.postId = postId
    }
}