package com.example.postdetailssample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.postdetailssample.model.SamplePost
import com.example.postdetailssample.repository.remote.RemotePostsRepository
import com.example.postdetailssample.repository.local.LocalPostsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class PostsListViewModel @Inject constructor(
    private val remotePostsRepository: RemotePostsRepository,
    private val localPostsRepository: LocalPostsRepository
) : BaseViewModel() {

    val postsData: LiveData<List<SamplePost>>
        get() = internalPostsData

    private val internalPostsData = MutableLiveData<List<SamplePost>>()

    fun loadPosts() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                localPostsRepository.savePosts(remotePostsRepository.loadPosts())
            } catch (e: Exception) {
                internalErrorMessageData.postValue(e.message)
            } finally {
                val posts = localPostsRepository.loadPosts()
                internalPostsData.postValue(posts)
            }
        }
    }
}