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
                        .padding(55.dp),
                    contentAlignment = Alignment.Center

                ) {

                    Image(
                        painter = painterResource(id = reward.image),
                        contentDescription = null,
                        modifier = Modifier
                            .size(180.dp)
                            .aspectRatio(1f, matchHeightConstraintsFirst = true)
                            .padding(3.dp),
                        contentScale = ContentScale.Crop
                    )

                }
            }

        }

}


@Preview(showBackground = true)
@Composable
fun CardPreview() {

}

