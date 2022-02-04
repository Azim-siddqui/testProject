package com.example.istjetpackcomposeapp.presentation.post.compose

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.istjetpackcomposeapp.R
import com.example.istjetpackcomposeapp.ui.theme.Typography


@Composable
fun UserCard() {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .width(180.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(2.dp)
    ) {
        Column() {
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painterResource(id = R.drawable.user_radha),
                    contentDescription = "user",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                )

                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(end = 6.dp, bottom = 6.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .background(
                            Color.Black.copy(0.5f)
                        )
                ) {
                    Row(modifier = Modifier.padding(3.dp)) {

                        Image(
                            painterResource(id = R.drawable.online_dot),
                            contentDescription = "dot",
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                        Spacer(modifier = Modifier.size(2.dp))
                        Text(
                            text = "Online",
                            style = TextStyle(
                                fontFamily = FontFamily.Monospace,
                                fontSize = 8.sp,
                                color = Color.White,
                            )
                        )
                    }

                }
            }
            Column(modifier = Modifier.padding(5.dp)) {
                Text(
                    text = "Aestro Mukesh",
                    style = TextStyle(
                        fontSize = 14.sp,
                    ),
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, end = 8.dp)
                )
                Text(
                    text = "Vastu Vedic Numerology, Kundli",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily.SansSerif
                    ),
                    modifier = Modifier.padding(bottom = 8.dp, end = 8.dp)
                )
                Row(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        painterResource(id = R.drawable.online_dot),
                        contentDescription = "dot",
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .size(15.dp)
                    )
                    Spacer(modifier = Modifier.size(5.dp))
                    Text(
                        text = "30/",
                        style = TextStyle(
                            fontFamily = FontFamily.Monospace,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = "min",
                        style = TextStyle(
                            fontFamily = FontFamily.Monospace,
                            fontSize = 8.sp
                        ),
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                    )

                    Spacer(
                        modifier = Modifier
                            .width(5.dp)
                            .background(Color.Blue)
                    )
                    Text(
                        text = "Exp:",
                        style = TextStyle(
                            fontFamily = FontFamily.Monospace,
                            fontSize = 12.sp
                        )
                    )
                    Text(
                        text = "2yrs",
                        style = TextStyle(
                            fontFamily = FontFamily.Monospace,
                            fontSize = 12.sp
                        )
                    )


                }

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp),
                    shape = RoundedCornerShape(4.dp)
                ) {

                    Text(text = "Connect")
                }

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    UserCard()
}