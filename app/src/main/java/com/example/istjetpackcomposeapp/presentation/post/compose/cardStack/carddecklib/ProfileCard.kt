package com.example.istjetpackcomposeapp.presentation.post.compose.cardStack.carddecklib

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.istjetpackcomposeapp.R
import com.example.istjetpackcomposeapp.presentation.post.compose.cardStack.Reward

@Composable
fun UserProfileCard(
//    profileThumb: String,
//    badgeThumb: String,
    modifier: Modifier = Modifier
){

    Card(
        modifier = modifier
            .fillMaxSize(),
        backgroundColor = Color.White
    ) {

        Box(
            modifier = Modifier,
            contentAlignment = Alignment.Center,
        ) {

            Image(
                painter = painterResource(id = R.drawable.gift_preview_back),
                contentDescription = null,
                modifier = modifier
                    .aspectRatio(1f, matchHeightConstraintsFirst = true)
            )

            Box(
                modifier = Modifier
                    .padding(70.dp),
                contentAlignment = Alignment.Center

            ) {

                Image(
                    painter = painterResource(id = R.drawable.bala_post),
                    contentDescription = null,
                    modifier = Modifier
                        .size(320.dp)
                        .aspectRatio(1f, matchHeightConstraintsFirst = true)
                        .padding(3.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Image(
                    painter = painterResource(id = R.drawable.level),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.BottomEnd)
                        .padding(end = 4.dp, bottom = 4.dp)
                )

            }
        }

    }
}