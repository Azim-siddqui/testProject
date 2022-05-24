package com.example.istjetpackcomposeapp.presentation.post.compose.astro

import android.widget.TextView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.graphics.toColorInt
import androidx.core.text.HtmlCompat
import com.example.istjetpackcomposeapp.R
import com.example.istjetpackcomposeapp.presentation.post.compose.astro.datamodels.PrivateConsultationDiscoveryData


@Composable
fun PrivateConsultationItemView(
    modifier: Modifier = Modifier,
    data: PrivateConsultationDiscoveryData = PrivateConsultationDiscoveryData(),
    onButtonClick: (privateConsultationDiscoveryData: PrivateConsultationDiscoveryData) -> Unit,
    onCardClick: (privateConsultationDiscoveryData: PrivateConsultationDiscoveryData) -> Unit
) {


    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        RoundImageWithBorder(
            image = painterResource(id = data.imageIconUrl),
            modifier = Modifier
                .size(80.dp),
            true
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = data.name,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            modifier = Modifier
                .width(120.dp)
                .height(32.dp),
            text = data.expertiseText,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            maxLines = 2
        )

        Spacer(modifier = Modifier.height(4.dp))

        ChargeAndSkillSection()

        Spacer(modifier = Modifier.height(8.dp))
        ConnectButton(Modifier.size(width = 100.dp, height = 25.dp))


    }
}

@Composable
fun ChargeAndSkillSection(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(start = 8.dp, end = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_coin),
            contentDescription = "Coin Icon",
            modifier = Modifier.size(16.dp),
            contentScale = ContentScale.FillBounds
        )
        AndroidView(
            factory = {
                TextView(it).apply {
                    text = HtmlCompat.fromHtml(
                        String.format("%s /min", "30"),
                        HtmlCompat.FROM_HTML_MODE_LEGACY
                    )
                    textSize = 12f
                    maxLines = 1
                }
            },
            modifier = Modifier.padding(start = 3.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Box(
            modifier = Modifier
                .width(1.dp)
                .height(12.dp)
                .background(Color.Black)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Exp: 4yrs",
            fontWeight = FontWeight.Normal,
            fontSize = 10.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun ConnectButton(modifier: Modifier = Modifier) {
    Button(
        onClick = {  },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color("#34C759".toColorInt()),
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(4.dp),
    ) {

        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.Call,
                contentDescription = "Bell Icon",
                modifier = Modifier.size(14.dp),
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "Connect",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            )
        }

    }

}

@Composable
fun OnlineCircularDot(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(Color("#34C759".toColorInt()), shape = CircleShape)
            .size(16.dp)
            .border(
                width = 2.dp,
                color = Color.White,
                shape = CircleShape,
            )
    )
}


@Composable
fun RoundImageWithBorder(
    image: Painter,
    modifier: Modifier = Modifier,
    isOnline: Boolean
) {

    Box {
        Image(
            painter = image,
            contentDescription = "user_profile",
            modifier = modifier
                .aspectRatio(1f, matchHeightConstraintsFirst = true)
                .border(
                    width = 1.5.dp,
                    color = Color("#34C759".toColorInt()),
                    shape = CircleShape,

                    )
                .padding(4.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        if(isOnline){
            OnlineCircularDot(
                Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 3.dp, bottom = 3.dp)
            )
        }

    }


}
