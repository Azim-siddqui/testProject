package com.example.istjetpackcomposeapp.domain.repository

import com.example.istjetpackcomposeapp.data.api.ApiService
import com.example.istjetpackcomposeapp.data.model.Post
import javax.inject.Inject

interface PostRepository{
    suspend fun getAllPost():List<Post>
}