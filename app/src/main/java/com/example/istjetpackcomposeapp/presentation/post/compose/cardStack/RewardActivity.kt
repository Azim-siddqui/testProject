package com.example.istjetpackcomposeapp.presentation.post.compose.cardStack

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.airbnb.lottie.compose.*
import com.example.istjetpackcomposeapp.R
import com.example.istjetpackcomposeapp.presentation.post.compose.cardStack.carddecklib.UserProfileCard

import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import sharechat.library.composeui.common.carddecklib.LazyCardStack
import sharechat.library.composeui.common.carddecklib.LazyStackIndicator
import sharechat.library.composeui.common.carddecklib.rememberDragManager

class RewardActivity : ComponentActivity() {


    @ExperimentalPagerApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val profileList = mutableListOf<UserGift>(UserGift(profileThumb = R.drawable.bala_post, badgeThumb = R.drawable.level))
            val rewardList = listOf<Reward>(
                Reward(
                    image = R.drawable.post4,
                    levelText = "Level 10",
                    message = "Congrats"
                ),
                Reward(
                    image = R.drawable.insta_user_profile,
                    levelText = "Level 10",
                    message = "Congrats"
                ),
//                Reward(
//                    image = R.drawable.reward_profile,
//                    levelText = "Level 10",
//                    message = "Congrats"
//                ),
//                Reward(
//                    image = R.drawable.reward_profile,
//                    levelText = "Level 10",
//                    message = "Congrats"
//                ),
//                Reward(
//                    image = R.drawable.insta_user_profile,
//                    levelText = "Level 10",
//                    message = "Congrats"
//                ),
//                Reward(
//                    image = R.drawable.reward_profile,
//                    levelText = "Level 10",
//                    message = "Congrats"
//                ),
//                Reward(
//                    image = R.drawable.insta_user_profile,
//                    levelText = "Level 10",
//                    message = "Congrats"
//                )
            )
            RewardScreen(rewardList, profileList)
        }
    }
}

@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun RewardScreen(rewardList: List<Reward>, profileList: MutableList<UserGift>) {

    var userLevellist:MutableList<ChatRoomLevelUpgrade> = mutableListOf()
    userLevellist.add(UserGift(profileThumb = R.drawable.bala_post, badgeThumb = R.drawable.level))
    userLevellist.addAll(rewardList)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(0.9f)),
        contentAlignment = Alignment.TopCenter

    ) {

        //background sparkle image
        // to keep track if the animation is playing
        // and play pause accordingly
        var isPlaying by remember {
            mutableStateOf(true)
        }
        // for speed
        var speed by remember {
            mutableStateOf(1f)
        }

        // remember lottie composition ,which
        // accepts the lottie composition result
        val composition by rememberLottieComposition(
            LottieCompositionSpec
                .RawRes(R.raw.celebration_confetti)
        )

        // to control the animation
        val progress by animateLottieCompositionAsState(
            // pass the composition created above
            composition,

            // Iterates Forever
            iterations = LottieConstants.IterateForever,

            // pass isPlaying we created above,
            // changing isPlaying will recompose
            // Lottie and pause/play
            isPlaying = isPlaying,

            // pass speed we created above,
            // changing speed will increase Lottie
            speed = speed,

            // this makes animation to restart when paused and play
            // pass false to continue the animation at which is was paused
            restartOnPlay = false

        )

        LottieAnimation(
            composition,
            progress,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.9f)
                .align(Alignment.TopCenter)
        )


        //main screen content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

//            HorizontalAutoScrollPager(
//                list = rewardList,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(256.dp)
//            )

            if (rewardList.isNotEmpty()) {
                if (rewardList.size > 1) {
                    val config = LocalConfiguration.current
                    val screenWidth = with(LocalDensity.current) {
                        config.screenWidthDp.dp.toPx()
                    }

                    val scope = rememberCoroutineScope()
                    val dragState = rememberDragManager(
                        animationSpec = tween(durationMillis = 500),
                        size = rewardList.size,
                        maxCards = 3,
                        scope = scope
                    )
                    LaunchedEffect(Unit) {
                        var swipingLeft = true
                        snapshotFlow {
                            dragState.topDeckIndex.value
                        }.map {
                            delay(2000)
                            if (it == 0) {
                                swipingLeft = false
                            } else if (it == rewardList.size - 1) {
                                swipingLeft = true
                            }
                            it
                        }.collect {
                            if (swipingLeft) {
                                dragState.swipeLeft()
                            } else {
                                dragState.swipeBack()
                            }
                        }
                    }

                    LazyCardStack(
                        items = /*joined(rewardList,profileList)*/userLevellist,
//                        primaryContent = {
//                            UserProfileCard()
//                        },
                        content = {
                            //RewardCard(reward = it as Reward)
                            getLevelUpgradeView(it)
                        },
                        maxElements = 3,
                        modifier = Modifier.size(350.dp),
                        cornerShape = RoundedCornerShape(5.dp),
                        isDragEnable = false,
                        dragState = dragState,
                        elevation = 5.dp,
                        scope = scope
                    )
                    LazyStackIndicator(
                        dragState = dragState,
                        count = when (rewardList.size+1) {
                            in 2..3 -> rewardList.size+1
                            else -> 3
                        },
                        activeColor = Color.White
                    )
                } else {
                    UserProfileCard(
                        modifier = Modifier
                            .size(350.dp)
                            .padding(start = 25.dp, end = 25.dp, top = 52.dp)
                    )
                }
            }

//            LazyCardStack(
//                items = rewardList as MutableList<Reward>,
//                maxElements = 3,
//                content = {
////
//                    RewardCard(reward = it)
//                },
//                modifier = Modifier.size(350.dp),
//                cornerShape = RoundedCornerShape(5.dp),
//                isDragEnable = false,
//                dragState = dragState,
//                elevation = 5.dp,
//
//            )

//            HorizontalPagerIndicator(
//                pagerState = pageState,
//                modifier = Modifier
//                    .align(Alignment.CenterHorizontally)
//                    .padding(16.dp),
//                activeColor = colorResource(id = R.color.white),
//                inactiveColor = colorResource(id = R.color.light_secondary)
//            )

            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "Level 10",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Congratulations on reaching new level. You have recieved new exclusive reward",
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = {},
                modifier = Modifier
                    .padding(horizontal = 80.dp, vertical = 20.dp)
                    .size(width = 135.dp, height = 40.dp)
                    .clip(RoundedCornerShape(8.dp)),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.btn_bg),
                    contentColor = Color.White
                )

            ) {
                Text(text = "Rewards")
            }

        }


        //bottom close button
        Column(modifier = Modifier.align(Alignment.BottomCenter)) {
            Divider(
                color = Color.White.copy(0.5f),
                thickness = 1.dp
            )
            Text(
                text = "Close",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black.copy(0.8f))
                    .padding(10.dp),
                style = TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    letterSpacing = 5.sp,
                    textAlign = TextAlign.Center
                )
            )
        }

    }
}


@ExperimentalMaterialApi
@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    val rewardList = listOf(
        Reward(
            image = R.drawable.reward_profile,
            levelText = "Level 10",
            message = "Congrats"
        ),
        Reward(
            image = R.drawable.insta_user_profile,
            levelText = "Level 10",
            message = "Congrats"
        ),
        Reward(
            image = R.drawable.reward_profile,
            levelText = "Level 10",
            message = "Congrats"
        ),
        Reward(
            image = R.drawable.bala_post,
            levelText = "Level 10",
            message = "Congrats"
        )
    )
   // RewardScreen(rewardList, profileList)
}

fun <T, U> joined(first: List<T>, second: List<U>): MutableList<Any> {
    val list: MutableList<Any> = ArrayList();
    list.addAll(first.map { i -> i as Any })
    list.addAll(second.map { i -> i as Any })
    return list
}


@Composable
fun getLevelUpgradeView(chatRoomLevelUpgrade: ChatRoomLevelUpgrade) : Unit{
    Log.e("chatRoomLevelUpgrade", "kjhjkssa")
    return when(chatRoomLevelUpgrade){
        is Reward -> {
            RewardCard(reward = chatRoomLevelUpgrade)
        }
        is UserGift -> {
            UserProfileCard()
        }
    }
}

