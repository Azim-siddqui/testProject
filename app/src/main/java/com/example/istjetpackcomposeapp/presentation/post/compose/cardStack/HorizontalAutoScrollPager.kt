package com.example.istjetpackcomposeapp.presentation.post.compose.cardStack


import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import kotlin.math.absoluteValue
import androidx.compose.ui.unit.IntOffset
import com.example.istjetpackcomposeapp.R
import com.google.accompanist.pager.*
import kotlinx.coroutines.delay
import java.lang.Thread.yield


@ExperimentalPagerApi
@Composable
fun HorizontalAutoScrollPager(list: List<ChatRoomLevelUpgrade>, modifier: Modifier = Modifier) {

    val pageState = rememberPagerState()

    LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(1000)
            tween<Float>(600)
            pageState.animateScrollToPage(
                page = (pageState.currentPage + 1) % (pageState.pageCount)
            )
        }
    }

    Column {
        HorizontalPager(
            count = list.size,
            // Add 32.dp horizontal padding to 'center' the pages
            contentPadding = PaddingValues(horizontal = 32.dp),
            state = pageState,
            modifier = modifier
                .fillMaxSize()
        ) { page ->

            getLevelUpgradeView(list[page], modifier = Modifier
                .size(256.dp))

//            Image(
//                painter = painterResource(id = list[page]),
//                contentDescription = null,
//                modifier = modifier
//                    .aspectRatio(1f, matchHeightConstraintsFirst = true)
//                    .size(250.dp)
//                    .graphicsLayer {
//                        // Calculate the absolute offset for the current page from the
//                        // scroll position. We use the absolute value which allows us to mirror
//                        // any effects for both directions
//                        val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
//
//                        // We animate the scaleX + scaleY, between 85% and 100%
//                        lerp(
//                            start = 0.85f,
//                            stop = 1f,
//                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
//                        ).also { scale ->
//                            scaleX = scale
//                            scaleY = scale
//                        }
//
//                        // We animate the alpha, between 50% and 100%
//                        alpha = lerp(
//                            start = 0.5f,
//                            stop = 1f,
//                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
//                        )
//                    }
//                    .offset {
//                        // Calculate the offset for the current page from the
//                        // scroll position
//                        val pageOffset =
//                            this@HorizontalPager.calculateCurrentOffsetForPage(page)
//                        // Then use it as a multiplier to apply an offset
//                        IntOffset(
//                            x = (36.dp * pageOffset).roundToPx(),
//                            y = 0
//                        )
//                    })
//        }
//
        HorizontalPagerIndicator(
            pagerState = pageState,
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(16.dp),
            activeColor = colorResource(id = R.color.white),
            inactiveColor = colorResource(id = R.color.light_secondary)
        )

        }
    }
}



