package com.example.istjetpackcomposeapp.presentation.post.compose.cardStack

data class Reward(
    val image : Int,
    val levelText : String,
    val message : String
):ChatRoomLevelUpgrade()

sealed class ChatRoomLevelUpgrade()

data class UserGift(
    val profileThumb : Int,
    val badgeThumb : Int
):ChatRoomLevelUpgrade()



data class Gift(
    val giftPicture : String
)