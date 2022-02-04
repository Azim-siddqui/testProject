package com.example.istjetpackcomposeapp.presentation.post


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.example.istjetpackcomposeapp.data.model.Post
import com.example.istjetpackcomposeapp.presentation.post.compose.PostRow
import com.example.istjetpackcomposeapp.presentation.viewmodel.PostsViewModel
import com.example.istjetpackcomposeapp.ui.theme.IstJetPackComposeAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostListActivity : ComponentActivity() {

    private val viewModel: PostsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IstJetPackComposeAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    GetData()
                }
            }
        }
    }

    @Composable
    fun GetData() {
        val list = viewModel.postListLiveData.observeAsState().value
        list?.let { PostRecycleView(postList = it) }

    }

    @Composable
    fun PostRecycleView(postList: List<Post>) {
        LazyColumn {
            items(postList) { post ->
                PostRow(post)
            }
        }
    }


}


