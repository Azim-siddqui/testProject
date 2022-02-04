package com.example.istjetpackcomposeapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.istjetpackcomposeapp.data.model.Post
import com.example.istjetpackcomposeapp.domain.usecase.GetPostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(private val getPostUseCase: GetPostUseCase) : ViewModel() {

    private val _postListLiveData = MutableLiveData<List<Post>>()
    val postListLiveData: LiveData<List<Post>>
        get() = _postListLiveData

    init {
        fetchPostData()
    }

     private fun fetchPostData() {
        viewModelScope.launch {
            val response = getPostUseCase.execute()
            _postListLiveData.value = response
        }
    }
}