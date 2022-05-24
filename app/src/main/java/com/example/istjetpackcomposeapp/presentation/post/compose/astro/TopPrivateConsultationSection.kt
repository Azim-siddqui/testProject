package com.example.istjetpackcomposeapp.presentation.post.compose.astro

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import com.example.istjetpackcomposeapp.presentation.post.compose.astro.datamodels.PrivateConsultationSection

@ExperimentalFoundationApi
@ExperimentalCoilApi
@Composable
fun PrivateConsultationSectionView(
    data: PrivateConsultationSection,
    onClickSeeMore: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(top = 8.dp, bottom = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = data.headerIconUrl),
                contentDescription = "star icon",
                modifier = Modifier
                    .size(20.dp)
            )
            Text(
                text = data.headerName,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 8.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            if (data.showSeeMoreButton) {
                Row(
                    modifier = Modifier
                        .clickable {
                            onClickSeeMore()
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "See more",
                        fontSize = 12.sp
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(start = 4.dp)
                            .size(10.dp)
                    )
                }
            }
        }

        LazyRow(
            modifier = Modifier
                .padding(top = 12.dp, start = 12.dp),
        ) {

                items(data.privateConsultationList){ privateConsultationData ->
                    PrivateConsultationItemView(
                        data = privateConsultationData,
                        onButtonClick = {},
                        onCardClick = {})
                }

        }
    }
}