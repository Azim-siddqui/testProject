package com.example.istjetpackcomposeapp.presentation.post.compose.astro

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.istjetpackcomposeapp.R


@Composable
fun AstroChatRoomItemView() {

    Box(
        modifier = Modifier
            .width(108.dp)
            .background(
                brush = Brush.linearGradient(
                    listOf(
                       "#FAFCFF",
                        "#E3F0FF"
                    ).map { Color(it.toColorInt()) }), shape = RoundedCornerShape(8.dp)
            )
    ) {

        Column(
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp, top = 12.dp, bottom = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            RoundImageWithBorder(
                image = painterResource(id = R.drawable.astrologer),
                modifier = Modifier
                    .size(72.dp),
                true
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Astro Poonamhgfhg",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row( horizontalArrangement = Arrangement.Center,) {
                Icon(
                    painter = painterResource(id = R.drawable.user_icon),
                    contentDescription = "user icon",
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = "9999",
                    fontSize = 12.sp,
                    maxLines = 1,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                )
            }

        }

    }


}


@Preview
@Composable
fun AstroChatRoomItemViewPreview() {
    AstroChatRoomItemView()
}