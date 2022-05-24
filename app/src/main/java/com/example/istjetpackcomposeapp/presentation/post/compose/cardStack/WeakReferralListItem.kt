package com.example.istjetpackcomposeapp.presentation.post.compose.cardStack

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.istjetpackcomposeapp.R
import com.example.istjetpackcomposeapp.presentation.post.compose.canvas.DrawBaseProgress
import com.example.istjetpackcomposeapp.presentation.post.compose.canvas.DrawTopProgress


@Composable
fun WeakReferralListItem(isCurrentUser:Boolean, color: Color ) {
    Row(
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .fillMaxWidth()
            .background(color),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {


            Divider(
                color = if(isCurrentUser) Color.Blue else Color.Transparent,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(5.dp)
            )

        Row(
            modifier = Modifier
                .padding(top = 10.dp, start = 8.dp, end = 10.dp, bottom = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(modifier = Modifier.size(16.dp), text = "1", textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.width(4.dp))
            Image(
                painter = painterResource(id = R.drawable.bala_post),
                contentDescription = "profile",
                modifier = Modifier
                    .size(48.dp)
                    .aspectRatio(1f, matchHeightConstraintsFirst = true)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))
            TitleAndSubTitleSection(Modifier.weight(3f))
            Spacer(modifier = Modifier.width(8.dp))
            Box(contentAlignment = Alignment.Center) {
                CoinProgressBar()
                CoinsSection(Modifier.align(Alignment.BottomCenter))
            }

        }

    }
}

@Composable
fun CoinProgressBar() {
    Box{
        val coins = 440
        val sweepAngle =  (coins.div(5)).times(180).toFloat()
        DrawBaseProgress(Color.Yellow,2.dp, 180f)
        DrawTopProgress(Color.Red,5.dp, sweepAngle.div(100))
    }
}

@Composable
fun CoinsSection(modifier: Modifier) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_coin),
            contentDescription = "coin",
            modifier = modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "1000",
            style = TextStyle(
                fontSize = 15.sp,
                color = colorResource(id = R.color.heading),
                fontWeight = FontWeight.Bold
            )
        )

    }
}

@Composable
fun TitleAndSubTitleSection(modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Sameer Khan",
            style = TextStyle(
                fontSize = 15.sp,
                color = colorResource(id = R.color.heading),
                fontWeight = FontWeight.Bold
            ),
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "@sameer001",
            style = TextStyle(
                fontSize = 12.sp,
                color = colorResource(id = R.color.sub_heading)
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    WeakReferralListItem(false, Color.LightGray)
}

