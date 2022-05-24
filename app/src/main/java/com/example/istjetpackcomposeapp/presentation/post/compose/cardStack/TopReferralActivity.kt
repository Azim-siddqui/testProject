package com.example.istjetpackcomposeapp.presentation.post.compose.cardStack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.*
import kotlinx.coroutines.CoroutineScope

class TopReferralActivity : ComponentActivity() {

    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val tabData = mutableListOf("Today", "This Week", "This Month")
            val pagerState = rememberPagerState(initialPage = 0)
            val coroutineScope = rememberCoroutineScope()
            var selectedTabIndex by remember {
                mutableStateOf(0)
            }
            TabsLayout(pagerState = pagerState, coroutineScope = coroutineScope, tabData = tabData){
                selectedTabIndex = it
            }
        }
    }
}

@ExperimentalPagerApi
@Composable
private fun TabsLayout(
    pagerState: PagerState,
    coroutineScope: CoroutineScope,
    tabData: List<String>,
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedTabIndex = pagerState.currentPage
    TabRow(
        selectedTabIndex = selectedTabIndex,
//        indicator = { tabPositions ->
//            TabRowDefaults.Indicator(
//                modifier = Modifier
//                    .pagerTabIndicatorOffset(pagerState, tabPositions),
//                color = Color.Black
//            )
//        },
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = Modifier.padding(10.dp)
    ) {
        tabData.forEachIndexed { index, data ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
//                    coroutineScope.launch {
//                        pagerState.animateScrollToPage(index)
//                    }
                },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.LightGray,
                text = {
                    Text(
                        text = data,
                        color = if (pagerState.currentPage == index) Color.Blue else Color.Black,
                        fontSize = 14.sp,
                        fontWeight = if (pagerState.currentPage == index) FontWeight.Bold else FontWeight.Normal
                    )
                }
            )
        }
    }
    Divider()

    HorizontalPager(
        state = pagerState,
        count = tabData.size,
        modifier = Modifier.height(700.dp)
    ) { index ->
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            when (index) {
                0 -> {
                    TodayScreen()
                }
                1 -> {
                    ThisWeekScreen()
                }
                2 -> {
                    ThisMonthScreen()
                }
            }
        }
    }

}
