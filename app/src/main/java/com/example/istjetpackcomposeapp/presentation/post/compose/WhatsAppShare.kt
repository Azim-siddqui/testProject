package com.example.istjetpackcomposeapp.presentation.post.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun WhatsAppShare(onButtonClick: Unit){

    Button(
        onClick = { onButtonClick },
    modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)) {
        Text(text = "Share on whatsapp")
    }
}


