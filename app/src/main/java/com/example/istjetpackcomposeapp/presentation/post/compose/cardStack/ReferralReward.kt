package com.example.istjetpackcomposeapp.presentation.post.compose.cardStack

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.istjetpackcomposeapp.R

@Composable
fun ReferralReward() {
    Card(
        modifier = Modifier
            .size(256.dp)
            .padding(22.dp),
        backgroundColor = Color.White,
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(
            modifier = Modifier
                .size(160.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.spark_frame),
                contentDescription = null,
                modifier = Modifier
                    .aspectRatio(1f, matchHeightConstraintsFirst = true)
            )
            Image(
                painter = painterResource(id = R.drawable.spin),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp)
                    .aspectRatio(1f, matchHeightConstraintsFirst = true)

            )
            Row(
                modifier = Modifier
                    .size(256.dp, 36.dp)
                    .background(color = colorResource(id = R.color.orangish))
                    .align(Alignment.BottomCenter),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(
                    modifier = Modifier
                        .size(256.dp, 20.dp)
                        .background(color = colorResource(id = R.color.orangish)),
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    text = "Spin & Win upto 1000 coins",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReferralPreview() {
    ReferralReward()
}
