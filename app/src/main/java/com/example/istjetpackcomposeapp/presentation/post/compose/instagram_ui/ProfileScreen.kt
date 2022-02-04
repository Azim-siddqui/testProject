package com.example.istjetpackcomposeapp.presentation.post.compose.instagram_ui

import android.media.Image
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.istjetpackcomposeapp.R
import com.example.istjetpackcomposeapp.data.model.IconWithText
import javax.annotation.meta.When


@ExperimentalFoundationApi
@Composable
fun ProfileScreen() {

    var selectedTabIndex by remember {
        mutableStateOf(0)
    }


    Column(modifier = Modifier.fillMaxSize()) {
        TopBar("bala_khatoon")
        Spacer(modifier = Modifier.height(5.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(5.dp))
        ButtonSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(5.dp))

        var list = listOf<IconWithText>(
            IconWithText(
                image = painterResource(id = R.drawable.ic_youtube),
                text = "Youtube"
            ),
            IconWithText(
                image = painterResource(id = R.drawable.ic_qna),
                text = "QnA"
            ),
            IconWithText(
                image = painterResource(id = R.drawable.ic_youtube),
                text = "Youtube"
            ),
            IconWithText(
                image = painterResource(id = R.drawable.ic_youtube),
                text = "Youtube"
            ),
            IconWithText(
                image = painterResource(id = R.drawable.ic_youtube),
                text = "Youtube"
            ),
            IconWithText(
                image = painterResource(id = R.drawable.ic_youtube),
                text = "Youtube"
            )
        )
        HighlightSection(
            highlights = list,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        TabsSection(
            listOfTabs = listOf(
                IconWithText(
                    image = painterResource(id = R.drawable.ic_grid),
                    text = "Post"
                ),
                IconWithText(
                    image = painterResource(id = R.drawable.ic_reel),
                    text = "Reels"
                ),
                IconWithText(
                    image = painterResource(id = R.drawable.ic_igtv),
                    text = "IGTV"
                ),
                IconWithText(
                    image = painterResource(id = R.drawable.ic_user),
                    text = "Profile"
                )
            ),
            modifier = Modifier.fillMaxWidth(),
        ){
            selectedTabIndex = it
        }
        when(selectedTabIndex){
            0 -> PostSection(
                modifier =  Modifier.fillMaxWidth(),
                listOfPost = listOf(
                    painterResource(id = R.drawable.bala_post),
                    painterResource(id = R.drawable.post2),
                    painterResource(id = R.drawable.post3),
                    painterResource(id = R.drawable.post4),
                    painterResource(id = R.drawable.post5),
                    painterResource(id = R.drawable.bala_post),
                    painterResource(id = R.drawable.post2),
                    painterResource(id = R.drawable.post3),
                    painterResource(id = R.drawable.post4),
                    painterResource(id = R.drawable.post5),
                    painterResource(id = R.drawable.bala_post),
                    painterResource(id = R.drawable.post2),
                    painterResource(id = R.drawable.post3),
                    painterResource(id = R.drawable.post4),
                    painterResource(id = R.drawable.post5)
                )
            )
        }
    }
}


@Composable
fun TopBar(name: String) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 5.dp, end = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        )
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
    }
}


@Composable
fun ProfileSection(modifier: Modifier = Modifier) {

    Column(modifier = modifier.fillMaxWidth()) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {

            RoundImage(
                image = painterResource(id = R.drawable.insta_user_profile),
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(modifier = Modifier.weight(7f))

        }
        ProfileDescription(
            name = "Bala (Turkish Model)",
            description = "Actor-Model, worked in Turkish serial\n" +
                    "Want to talk me, dm me or send me an email",
            url = "https://balamodel.com/",
            followedBy = listOf("usman", "bamsi", "ertugrul", "Gunja", "boran"),
            otherCount = 15
        )

    }

}

@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
) {

    Image(
        painter = image,
        contentDescription = "user_profile",
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Crop
    )

}


@Composable
fun StatSection(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        ProfileStat(number = "300", label = "Posts")
        ProfileStat(number = "200k", label = "Followers")
        ProfileStat(number = "20", label = "Following")

    }
}

@Composable
fun ProfileStat(number: String, label: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = number,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = label)
    }
}

@Composable
fun ProfileDescription(
    name: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {

        Text(
            text = name,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        )
        Text(
            text = description,
            style = TextStyle(
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        )
        Text(
            text = url,
            color = Color.Blue,
            style = TextStyle(
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        )

        Text(
            text = buildAnnotatedString {
                val boldStyle = SpanStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                append("Followed by ")
                pushStyle(boldStyle)
                followedBy.take(3).forEachIndexed { index, name ->
                    pushStyle(boldStyle)
                    append(name)
                    pop()
                    if (index < followedBy.size - 1)
                        append(", ")

                }
                if (otherCount > 2) {
                    append(" and ")
                    pushStyle(boldStyle)
                    append("$otherCount others")
                }
            },
            style = TextStyle(
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        )

    }
}


@Composable
fun ButtonSection(
    modifier: Modifier = Modifier
) {

    val minWidth = 95.dp
    val height = 30.dp

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Email",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .height(height)
        )


    }


}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    text: String? = null,
) {
    Row(
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(2.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {

        if (text != null) {
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold
            )
        }
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black
            )
        }

    }
}


@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    highlights: List<IconWithText>
) {
    LazyRow(modifier = modifier) {
        items(highlights) { item ->
            HighLightItem(item)
        }
    }
}

@Composable
fun HighLightItem(
    highlight: IconWithText,
) {

    Column(
        modifier = Modifier.padding(end = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        RoundImage(
            image = highlight.image,
            modifier = Modifier.size(70.dp)
        )
        Text(
            text = highlight.text,
            overflow = TextOverflow.Ellipsis
        )
    }

}

@Composable
fun TabsSection(
    listOfTabs: List<IconWithText>,
    modifier: Modifier = Modifier,
    onTabSelected : (selectedIndex : Int) -> Unit
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = Modifier.padding(10.dp)
    ) {
        listOfTabs.forEachIndexed { index, item ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.LightGray,
                modifier = Modifier.padding(10.dp)
            ) {
                Icon(
                    painter = item.image,
                    contentDescription = item.text
                )
                Text(
                    text = item.text
                )
            }

        }
    }
}

@ExperimentalFoundationApi
@Composable
fun PostSection(
    modifier: Modifier,
    listOfPost: List<Painter>
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = modifier.scale(1.01f)
    ) {
        items(listOfPost) { post ->

            Image(
                painter = post,
                contentDescription = "null",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 2.dp,
                        color = Color.White
                    )
            )
        }
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun Preview() {
    ProfileScreen()

}