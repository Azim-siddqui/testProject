package com.example.istjetpackcomposeapp.presentation.post.compose.cardStack

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.istjetpackcomposeapp.R
import com.example.istjetpackcomposeapp.presentation.post.compose.instagram_ui.TopBar
import dev.chrisbanes.accompanist.insets.statusBarsHeight
import dev.chrisbanes.accompanist.insets.statusBarsPadding

@Composable
fun EditProfile() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        TitleBar(name = "Top Referrals")
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            painter = painterResource(id = R.drawable.cover),
            contentDescription = "Profile Cover",
            contentScale = ContentScale.Crop
        )
        ProfileImage()
        TopReferralTab()
        WeakReferralListItem(false, Color.DarkGray)
    }


}

@Composable
fun TitleBar(name: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 10.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back")
        Text(
            modifier = Modifier.padding(start = 20.dp), text = name,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            )
        )
    }
}

@Composable
fun TopReferralTab() {

}

@Composable
fun TodayScreen() {

}

@Composable
fun ThisWeekScreen() {

}

@Composable
fun ThisMonthScreen() {

}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ProfileImage() {
    Box(
        modifier = Modifier
            .offset(7.dp, -(25.dp))
            .padding(start = 5.dp, top = 8.dp)
            .size(80.dp)

    ) {
        Image(
            modifier = Modifier.clip(CircleShape),
            painter = painterResource(id = R.drawable.bala_post),
            contentDescription = "Profile pic",
            contentScale = ContentScale.Crop,
        )
        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(CircleShape)
                .background(color = Color.Black.copy(alpha = 0.6f))
                .padding(5.dp)
                .align(Alignment.BottomEnd)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_camera),
                contentDescription = "Camera picture"
            )
        }
    }

}


@Preview(showBackground = true)
@Composable
fun EditProfilePreview() {
    EditProfile()
}