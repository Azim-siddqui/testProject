package com.example.istjetpackcomposeapp.data

import com.example.istjetpackcomposeapp.data.model.Post

sealed class NetworkState{

    class Success(val data:List<Post>) : NetworkState()
    class Failure(val message : Throwable) : NetworkState()
    object Loading : NetworkState()
    object Empty : NetworkState()
}
