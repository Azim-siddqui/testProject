package com.example.istjetpackcomposeapp.presentation.post.compose.cardStack

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.istjetpackcomposeapp.R


@Composable
fun RewardCard(reward: Reward, modifier: Modifier = Modifier) {

    Card(
        modifier = modifier
            .fillMaxWidth(),
        backgroundColor = Color.White,
        shape = RoundedCornerShape(4.dp)
    ) {

            Box(
                modifier = Modifier,
                contentAlignment = Alignment.Center,
            ) {
                    Image(
                        painter = painterResource(id = R.drawable.insta_user_profile),
                        contentDescription = null,
                        modifier = modifier
                            .aspectRatio(1f, matchHeightConstraintsFirst = true),
                        contentScale = ContentScale.Crop
                    )
            }
        }

}


@Preview(showBackground = true)
@Composable
fun CardPreview() {

}

