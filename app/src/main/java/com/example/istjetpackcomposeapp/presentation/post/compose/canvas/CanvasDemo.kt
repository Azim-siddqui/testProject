package com.example.istjetpackcomposeapp.presentation.post.compose.canvas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class CanvasDemo : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DrawShapes()
        }
    }
}

@Composable
fun DrawShapes() {

    Canvas(
        modifier = Modifier.padding(20.dp).background(Color.Black).size(200.dp)
    ){
        drawArc(
            startAngle = 0f,
            sweepAngle = 270f,
            topLeft = Offset(100f,40f),
            useCenter = false,
            style = Stroke(
                width = 5.dp.toPx()
            ),
            size = Size(200f,200f),
            color = Color.Yellow,

        )
    }
}


@Preview(showBackground = true)
@Composable
fun CanvasPreview() {
    DrawShapes()
}