package com.example.istjetpackcomposeapp.data.repository.remote

import com.example.istjetpackcomposeapp.data.model.Post
import retrofit2.Response

interface RemoteDataSource {
    suspend fun getAllPost():Response<List<Post>>
}