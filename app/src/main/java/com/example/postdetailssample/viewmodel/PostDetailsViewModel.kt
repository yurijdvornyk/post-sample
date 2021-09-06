package com.example.postdetailssample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.postdetailssample.model.SamplePost
import com.example.postdetailssample.model.SampleUser
import com.example.postdetailssample.repository.remote.RemotePostsRepository
import com.example.postdetailssample.repository.remote.RemoteUserRepository
import com.example.postdetailssample.repository.local.LocalPostsRepository
import com.example.postdetailssample.repository.local.LocalUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostDetailsViewModel @Inject constructor(
    private val remotePostsRepository: RemotePostsRepository,
    private val localPostsRepository: LocalPostsRepository,
    private val remoteUserRepository: RemoteUserRepository,
    private val localUserRepository: LocalUserRepository
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
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    val postDetails = remotePostsRepository.loadPostDetails(it)
                    localUserRepository.saveUserDetails(
                        remoteUserRepository.loadUserDetails(postDetails.userId)
                    )
                } catch (e: Exception) {
                    internalErrorMessageData.postValue(e.message)
                } finally {
                    postId?.let {
                        val post = localPostsRepository.loadPostDetails(it)
                        internalPostData.postValue(post)
                        internalUserData.postValue(localUserRepository.loadUserDetails(post.userId))
                    }
                }
            }
        }
    }

    fun initialize(postId: Int?) {
        this.postId = postId
    }
}