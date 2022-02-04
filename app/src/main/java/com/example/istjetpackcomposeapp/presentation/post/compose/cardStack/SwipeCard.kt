package com.example.istjetpackcomposeapp.presentation.post.compose.cardStack


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember


/**
 * Swipeable card. Uses Modifier property of swiper
 * It provides a swipe result with an enum ACCEPT or REJECT
 */
@ExperimentalMaterialApi
@Composable
fun SwipeCard(
    modifier: Modifier = Modifier,
    content: @Composable (BoxScope.() -> Unit)
) {
    val swiped = remember { mutableStateOf(false) }
    BoxWithConstraints(modifier = modifier) {
        val swipeState = rememberSwipeState(
            maxWidth = constraints.maxWidth.toFloat(),
            maxHeight = constraints.maxHeight.toFloat()
        )
        if (swiped.value.not()) {
            Box(
                modifier = Modifier
                    .swiper(
                        state = swipeState,
                        onDragAccepted = {
                            swiped.value = true
                        },
                        onDragRejected = {
                            swiped.value = true
                        }
                    ),
                content = content
            )
        }
    }
}

enum class SwipeResult { ACCEPT, REJECT }
