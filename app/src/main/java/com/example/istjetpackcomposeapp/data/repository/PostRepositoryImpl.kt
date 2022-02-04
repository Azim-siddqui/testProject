package com.example.istjetpackcomposeapp.data.repository

import com.example.istjetpackcomposeapp.data.model.Post
import com.example.istjetpackcomposeapp.data.repository.remote.RemoteDataSource
import com.example.istjetpackcomposeapp.domain.repository.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) :PostRepository {

    override suspend fun getAllPost() : List<Post>  {
        val list = ArrayList<Post>()
        val response = remoteDataSource.getAllPost()
        if(response.isSuccessful){
            response.body()?.let { list.addAll(it) }
        }
      return list
    }
}