package com.example.istjetpackcomposeapp.presentation.post.compose.canvas

import android.graphics.drawable.ColorStateListDrawable
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt

class CanvasDemo : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box {
                val coins = 440
                val sweepAngle = (coins.div(5)).times(180).toFloat()
                DrawBaseProgress(Color.Yellow, 1.dp, 180f)
                DrawTopProgress(Color.Red, 6.dp, 180.4f)
            }

        }
    }
}

@Composable
fun DrawBaseProgress(color: Color, width: Dp, sweepAngle: Float) {

    Canvas(
        modifier = Modifier
            .size(height = 50.dp, width = 90.dp)
            .clip(shape = RectangleShape),
    ) {

        drawArc(
            startAngle = 180f,
            sweepAngle = sweepAngle,
            topLeft = Offset(10f, 25f),
            useCenter = false,
            style = Stroke(
                width = width.toPx(),
                cap = StrokeCap.Round,
            ),
            size = Size(220f, 220f),
            color = Color("#FDD6B0".toColorInt())

        )


    }
}


@Composable
fun DrawTopProgress(color: Color, width: Dp, sweepAngle: Float) {

    Canvas(
        modifier = Modifier
            .size(height = 50.dp, width = 90.dp)
            .clip(shape = RectangleShape),
    ) {

        drawArc(
            startAngle = 180f,
            sweepAngle = sweepAngle,
            topLeft = Offset(10f, 25f),
            useCenter = false,
            style = Stroke(
                width = width.toPx(),
                cap = StrokeCap.Round,
            ),
            size = Size(220f, 220f),
            brush = Brush.horizontalGradient(
                colors = listOf(
                    Color("#EF7C35".toColorInt()),
                    Color("#FADD34".toColorInt())
                )
            )
        )


    }
}


@Preview(showBackground = true)
@Composable
fun CanvasPreview() {
//    Box {
//        val coins = 440
//        val sweepAngle = (coins.div(5)).times(180).toFloat()
//
//        DrawBaseProgress(Color.Yellow, 2.dp, 180f)
//        DrawTopProgress(Color.Red, 6.dp, sweepAngle.div(100))
//    }

    WeightDemo()
}


@Composable
fun WeightDemo() {

    Column(){
        Box(modifier = Modifier.fillMaxWidth().background(Color.Red).weight(3f))
        Box(modifier = Modifier.fillMaxWidth().background(Color.Blue).weight(1f))
    }

}