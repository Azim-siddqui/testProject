package com.azimsiddiqui.todolistjetpackcompose

import android.media.Image
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.azimsiddiqui.todolistjetpackcompose.data.model.Reward
import com.azimsiddiqui.todolistjetpackcompose.data.model.RewardModel
import com.azimsiddiqui.todolistjetpackcompose.data.model.Todo
import com.azimsiddiqui.todolistjetpackcompose.presentation.TodoViewModel
import com.azimsiddiqui.todolistjetpackcompose.ui.theme.TodoListJetPackComposeTheme
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import com.google.accompanist.flowlayout.SizeMode
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val todoViewModel: TodoViewModel by viewModels()
    private val handler = Handler(Looper.getMainLooper())

    private lateinit var rewardList: List<Reward>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoListJetPackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    val (showDialog, setShowDialog) = remember {
                        mutableStateOf(false)
                    }
                    val onClose = { setShowDialog(false) }
                    val isVisible = { setShowDialog(true) }


                    rewardList = ArrayList()
                    rewardList = listOf(
                        Reward(R.drawable.scratch_card),
                        Reward(R.drawable.scratch_card3),
                        Reward(R.drawable.scratch_card3)
                    )
                    val rewardModel = RewardModel(
                        list = rewardList,
                        title = "Congratulations!",
                        subTitle = "You have unlocked new rewards for completing all your daily task"
                    )

                    val runnable = remember {
                        Runnable { onClose() }
                    }

                    LaunchedEffect(key1 = showDialog, block = {
                        if (showDialog) {
                            handler.removeCallbacks(runnable)
                            handler.postDelayed(runnable, 3000)
                        } else {

                            handler.removeCallbacks(runnable)
                        }
                    })


                    Scaffold(
                        topBar = {
                            TopAppBar(title = {
                                Text(text = "ToDo App")
                            })
                        },
                        floatingActionButton = {
                            FloatingActionButton(onClick = isVisible) {
                                Icon(Icons.Default.Add, contentDescription = "Add")
                            }
                        }
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(20.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Hey Welcome",
                                color = Color.Red,
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Monospace,
                            )
                        }
                        RewardDialog(showDialog = showDialog, onClose, rewardModel)
                    }

                }
            }
        }
    }


    @Composable
    fun RewardDialog(showDialog: Boolean, onClose: () -> Unit, rewardModel: RewardModel) {

        if (showDialog) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(0.5f))
                    .clickable(onClick = onClose),

                ) {
                Image(
                    painter = painterResource(R.drawable.sparkle_rectangle_back),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.9f)
                        .align(Alignment.TopCenter),
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {

//                    if (rewardModel.list.size in 1..3) {
//                     //   AdaptiveRow()
//                        when (rewardModel.list.size) {
//                            1 -> {
//                                OneRewardRow(list = rewardModel.list)
//                            }
//                            2 -> {
//                                OneRewardRow(list = rewardModel.list)
//                            }
//                            3 -> {
//                                ThreeRewardRow(list = rewardModel.list)
//                            }
//                        }
//                    }

                    AdaptiveRow(listOfModel = rewardModel.list)
                    Text(
                        text = rewardModel.title, modifier = Modifier
                            .padding(5.dp)
                            .align(Alignment.CenterHorizontally),
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = rewardModel.subTitle,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .align(Alignment.CenterHorizontally),
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }

    @Composable
    fun OneRewardRow(list: List<Reward>) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            for (item in list) {
                Image(
                    painter = painterResource(id = item.image),
                    contentDescription = "image",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .weight(1f)
                        .fillMaxWidth()
                )
            }

        }

    }

    @Composable
    fun ThreeRewardRow(list: List<Reward>) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = list[0].image),
                    contentDescription = "image",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .height(150.dp)
                        .width(150.dp),
                )
            }

            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = list[1].image),
                    contentDescription = "image",
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    contentScale = ContentScale.FillHeight
                )
                Image(
                    painter = painterResource(id = list[2].image),
                    contentDescription = "image",
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    contentScale = ContentScale.FillHeight
                )
            }
        }

    }

    enum class CardAlign {
        LEFT,
        RIGHT,
        CENTRE
    }

//    @Composable
//    fun AdaptiveRow(){
//        FlowRow(modifier = Modifier
//            .fillMaxWidth()
//            .wrapContentHeight()){
//            for(item in rewardList) {
//                RewardImage(modifier = Modifier.fillMaxWidth(fraction = item.fraction), image = item.image, align = item.align)
//            }
//        }
//    }

    @Composable
    fun AdaptiveRow(listOfModel: List<Reward>) {
        val spanCount = 2
        val totalSize = listOfModel.size
        val fraction = 1f.div(spanCount)
        //Span count closest multiple should be my threshold value for choosing whether it will be in the same line or in a orphan state
        val orphanThreshold =
            totalSize.coerceAtMost(maximumValue = totalSize.div(spanCount) * spanCount)
        val orphanFraction = 1f.div(totalSize - orphanThreshold)
        val leftSide = 0 until spanCount.div(2) //
        val rightSide =
            if (spanCount % 2 == 0) spanCount.div(2) until spanCount else spanCount.div(2) + 1 until spanCount
        val center = if (spanCount % 2 == 0) -1 else spanCount.div(2)

        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {

            listOfModel.forEachIndexed { index, reward ->
                //It will determine the relative value of the index wrt a specific row
                val indexInRange = index % spanCount
                RewardImage(
                    modifier = Modifier.fillMaxWidth(fraction = if (index < orphanThreshold) fraction else orphanFraction),
                    image = reward.image,
                    align = when {
                        index >= orphanThreshold && orphanFraction == 1f -> CardAlign.CENTRE
                        indexInRange in leftSide -> CardAlign.RIGHT
                        indexInRange in rightSide -> CardAlign.LEFT
                        indexInRange == center && center != -1 -> CardAlign.CENTRE
                        else -> CardAlign.CENTRE
                    }
                )
            }
        }
    }

    @Composable
    fun CardImage(modifier: Modifier, color: Color, align: CardAlign = CardAlign.CENTRE) {
        Row(
            modifier = modifier
                .padding(5.dp),
            horizontalArrangement = when (align) {
                CardAlign.CENTRE -> Arrangement.Center
                CardAlign.LEFT -> Arrangement.Start
                CardAlign.RIGHT -> Arrangement.End
            }
        ) {
            Box(
                modifier = Modifier
                    .background(color = color)
                    .size(100.dp)
            )
        }
    }

    @Composable
    fun RewardImage(modifier: Modifier, image: Int, align: CardAlign = CardAlign.CENTRE) {
        Row(
            modifier = modifier
                .padding(5.dp),
            horizontalArrangement = when (align) {
                CardAlign.CENTRE -> Arrangement.Center
                CardAlign.LEFT -> Arrangement.Start
                CardAlign.RIGHT -> Arrangement.End
            }
        ) {
            Box(
                modifier = Modifier.size(150.dp)
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "image",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .fillMaxWidth(),
                    )
            }

        }
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        TodoListJetPackComposeTheme {
            Row(modifier = Modifier.fillMaxWidth()) {
//                rewardList = ArrayList()
//                (rewardList as ArrayList<Reward>).add(Reward(R.drawable.scratch_card))
//                (rewardList as ArrayList<Reward>).add(Reward(R.drawable.scartch_card2))
//                (rewardList as ArrayList<Reward>).add(Reward(R.drawable.scratch_card3))
//                ThreeRewardRow(list = rewardList)

                Box(
                    modifier = Modifier.size(100.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.scratch_card3),
                        contentDescription = "image",
                        contentScale = ContentScale.FillHeight,
                        modifier = Modifier
                            .fillMaxWidth(),

                        )
                }
                Box(
                    modifier = Modifier.size(100.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.scartch_card2),
                        contentDescription = "image",
                        contentScale = ContentScale.FillHeight,
                        modifier = Modifier
                            .fillMaxWidth(),
                        )
                }



            }

        }

    }
}






