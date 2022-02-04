package com.example.istjetpackcomposeapp.presentation.post.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.istjetpackcomposeapp.data.model.Post

@Composable
fun PostRow(post: Post) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 2.dp,
        shape = RoundedCornerShape(4.dp)
    ) {
        Column(modifier = Modifier.padding(5.dp)) {
            Text(
                text = post.id.toString(),
                modifier = Modifier.fillMaxWidth()
            )
            Text(text = post.body, modifier = Modifier.fillMaxWidth())
        }
    }
}