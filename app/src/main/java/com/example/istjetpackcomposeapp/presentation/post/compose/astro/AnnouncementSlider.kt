package com.example.istjetpackcomposeapp.presentation.post.compose.astro

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.istjetpackcomposeapp.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState


@OptIn(ExperimentalPagerApi::class)
@Composable
fun AnnouncementSlider(modifier: Modifier = Modifier, bannerList: List<Int>) {

    val pagerState = rememberPagerState()

    HorizontalPager(
        count = bannerList.size,
        state = pagerState,
        modifier = modifier.background(Color.Red)
    ) { page ->
        BannerWithIndicator(bannerList[page], modifier, pagerState)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BannerWithIndicator(image: Int, modifier: Modifier = Modifier, pagerState: PagerState) {

    Box {
        Image(
            painter = painterResource(id = image),
            contentDescription = "Banner",
            modifier = modifier,
            contentScale = ContentScale.FillBounds
        )
        HorizontalPagerIndicator(
            pagerState = pagerState, modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(8.dp),
            activeColor = colorResource(id = R.color.white),
            inactiveColor = Color.Gray,
            indicatorShape = CircleShape,
            indicatorWidth = 8.dp,
            spacing = 13.dp
        )
    }

}
