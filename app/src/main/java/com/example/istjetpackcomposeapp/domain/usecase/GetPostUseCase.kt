package com.example.istjetpackcomposeapp.domain.usecase

import com.example.istjetpackcomposeapp.data.model.Post
import com.example.istjetpackcomposeapp.domain.repository.PostRepository
import javax.inject.Inject

class GetPostUseCase @Inject constructor(private val repository: PostRepository) {

    suspend fun execute() : List<Post> = repository.getAllPost()
}