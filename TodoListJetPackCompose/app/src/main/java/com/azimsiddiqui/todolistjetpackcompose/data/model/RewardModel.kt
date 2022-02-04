package com.azimsiddiqui.todolistjetpackcompose.data.model

import androidx.compose.ui.graphics.Color
import com.azimsiddiqui.todolistjetpackcompose.MainActivity

data class RewardModel(
    val list: List<Reward>,
    val title:String,
    val subTitle:String,
)

data class Reward(
    val image:Int
)

