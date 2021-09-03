package com.example.postdetailssample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.postdetailssample.model.SamplePost
import com.example.postdetailssample.repository.PostsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val repository: PostsRepository
) : BaseViewModel() {

    val postsData: LiveData<List<SamplePost>>
        get() = internalPostsData

    private val internalPostsData = MutableLiveData<List<SamplePost>>()

    fun loadPosts() {
        viewModelScope.launch {
            try {
                internalPostsData.postValue(repository.loadPosts())
            } catch (e: Exception) {
                internalErrorMessageData.postValue(e.message)
            }
        }
    }
}