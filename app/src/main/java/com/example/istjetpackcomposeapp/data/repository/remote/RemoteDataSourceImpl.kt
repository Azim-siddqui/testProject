package com.example.istjetpackcomposeapp.data.repository.remote

import com.example.istjetpackcomposeapp.data.api.ApiService
import com.example.istjetpackcomposeapp.data.model.Post
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val apiService: ApiService) :
    RemoteDataSource {

    override suspend fun getAllPost(): Response<List<Post>> {
        return apiService.getPosts()
    }
}