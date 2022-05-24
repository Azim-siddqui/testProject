package com.example.istjetpackcomposeapp.presentation.post.compose.astro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.istjetpackcomposeapp.R


@Composable
fun PreviouslyConsultedItemView() {

    Card(
        modifier = Modifier
            .width(370.dp)
            .background(Color.White),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                RoundImageWithBorder(
                    image = painterResource(id = R.drawable.astrologer),
                    modifier = Modifier
                        .size(56.dp)
                        .weight(3f),
                    true
                )
                Spacer(modifier = Modifier.width(20.dp))
                AstroDetailSection(
                    modifier = Modifier
                        .weight(7f)
                )
            }
            Divider(modifier = Modifier.height(1.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                ChargeAndSkillSection(Modifier.weight(1f))
                ConnectButton(
                    Modifier
                        .width(120.dp))
            }
        }
    }
}

@Composable
fun AstroDetailSection(modifier: Modifier = Modifier) {

    Box(modifier = modifier) {
        Column() {
            Text(
                text = "Astrology Guru",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Start,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                modifier = Modifier.fillMaxWidth(0.8f),
                text = "Love, Marriage, Career, Numerology bhgabdhjbahsdghjasdadfc",
                fontSize = 12.sp,
                maxLines = 1,
                fontWeight = FontWeight.Medium,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Start
            )
        }
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .clip(RoundedCornerShape(4.dp))
                .background(
                    Color("#FEF1E7".toColorInt())
                )
        ) {
            Row(
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "4.5", fontSize = 12.sp)
                Spacer(modifier = Modifier.width(2.dp))
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Rating star",
                    modifier = Modifier.size(10.dp),
                    tint = Color("#7F5606".toColorInt())
                )

            }
        }
    }
}


@Preview
@Composable
fun PreviouslyConsultedItemViewPreview() {
    PreviouslyConsultedItemView()
}