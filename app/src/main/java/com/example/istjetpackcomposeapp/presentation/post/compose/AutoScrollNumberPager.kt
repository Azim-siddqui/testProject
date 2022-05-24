package com.example.istjetpackcomposeapp.presentation.post.compose

import android.util.Log
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import kotlin.math.absoluteValue
import com.google.accompanist.pager.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield


/*
* @author Azim
*/
@ExperimentalPagerApi
@Composable
fun AutoScrollNumberPager(
    normalList: List<Int>,
    lightList: List<Int>,
    modifier: Modifier = Modifier
) {

    val pageState = rememberPagerState()
    val scope = rememberCoroutineScope()

//    LaunchedEffect(Unit) {
//        while (true) {
//            yield()
//            delay(2000)
//            tween<Float>(7000)
//            pageState.animateScrollToPage(
//                page = (pageState.currentPage + 1) % (pageState.pageCount)
//            )
//        }
//    }


        HorizontalPager(
            count = normalList.size,
            contentPadding = PaddingValues(horizontal = 130.dp),
            state = pageState,
            modifier = modifier
                .fillMaxSize()
        ) { page ->
            Log.i(
                "page",
                "AutoScrollNumberPager: current is ${pageState.currentPage} and page is $page"
            )

            val item = lerp(
                start = lightList[page],
                stop = normalList[page],
                fraction = 1f
            )

            Image(
                painter = painterResource(
                    id = item
                ),
                contentDescription = "number",
                modifier = Modifier
                    .aspectRatio(1f, matchHeightConstraintsFirst = true)
                    .graphicsLayer {
                        // Calculate the absolute offset for the current page from the
                        // scroll position. We use the absolute value which allows us to mirror
                        // any effects for both directions
                        val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                        // We animate the scaleX + scaleY, between 50% and 100%
                        lerp(
                            start = 0.6f,
                            stop = 1.1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }
                        alpha = lerp(
                            start = 0.5f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )

                        translationY = lerp(
                            start = 110f,
                            stop = 0f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                    }
                    .clickable {

                        if (pageState.currentPage != page) {

                            scope.launch {

                                pageState.animateScrollToPage(
                                    page = if (page < pageState.currentPage) {
                                        pageState.currentPage-1
                                    } else {
                                        pageState.currentPage + 1
                                    }
                                )
                            }
                        }
                    }
                //colorFilter = ColorFilter.colorMatrix(matrix),
            )
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


//            HorizontalPagerIndicator(
//                pagerState = pageState,
//                modifier = Modifier
//                    .align(CenterHorizontally)
//                    .padding(16.dp),
//                activeColor = colorResource(id = R.color.white),
//                inactiveColor = colorResource(id = R.color.light_secondary)
//            )


        }



}
