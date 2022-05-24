package com.example.istjetpackcomposeapp.presentation.post.compose

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Html
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.example.istjetpackcomposeapp.R
import com.example.istjetpackcomposeapp.presentation.post.compose.astro.AnnouncementSlider
import com.example.istjetpackcomposeapp.presentation.post.compose.astro.PrivateConsultationSectionView
import com.example.istjetpackcomposeapp.presentation.post.compose.astro.datamodels.PrivateConsultationSection
import com.google.accompanist.pager.ExperimentalPagerApi


class ReferEarnLandingActivity : ComponentActivity() {

    @OptIn(ExperimentalFoundationApi::class)
    @ExperimentalPagerApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Box(
                modifier = Modifier
                    .size(256.dp).background(color = Color.Yellow),
                contentAlignment = Alignment.Center
            ) {

                Image(
                    painter = painterResource(id = R.drawable.shine_back),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()

                )

//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .background(Color.Magenta)
//                        .align(Alignment.BottomCenter),
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.Center,
//                ) {
//                    Text(
//                        fontSize = 15.sp,
//                        textAlign = TextAlign.Center,
//                        text = "Test Reward",
//                        color = Color.Black,
//                        fontWeight = FontWeight.Bold,
//                        modifier = Modifier
//                            .padding(8.dp)
//                    )
//                }
            }

//            LazyColumn(
//                modifier = Modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.Top
//            ) {
//                item {
//                    AnnouncementSlider(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(156.dp), listOf(
//                            R.drawable.banner1,
//                            R.drawable.banner2,
//                            R.drawable.banner3
//                        )
//                    )
//                }
//                item {
//                    Spacer(modifier = Modifier.height(8.dp))
//                }
//                item {
//                    PrivateConsultationSectionView(
//                        PrivateConsultationSection(),
//                        onClickSeeMore = {})
//                }
//            }
        }
    }
}

fun shareOnWhatsapp(context: Context, downloadMessage: String, referralLink: String) {

    val emailIntent = Intent(Intent.ACTION_SEND);

    emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Trip from Voyajo");
    emailIntent.putExtra(
        android.content.Intent.EXTRA_TEXT,
        Html.fromHtml("I've found a trip in Voyajo website that might be interested you, http://www.voyajo.com/viewTrip.aspx?trip=" + referralLink)
    );
    emailIntent.setType("text/plain");
    startActivity(context, Intent.createChooser(emailIntent, "Send to friend"), Bundle())


    val sendIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
        type = "text/plain"
    }

    val shareIntent = Intent.createChooser(sendIntent, null)
    // startActivity(shareIntent)

//
//    val imageUri: Uri = Uri.parse(pictureFile.getAbsolutePath())
//    val shareIntent = Intent()
//    shareIntent.action = Intent.ACTION_SEND
//    //Target whatsapp:
//    shareIntent.setPackage("com.whatsapp")
//    //Add text and then Image URI
//    shareIntent.putExtra(Intent.EXTRA_TEXT, picture_text)
//    shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri)
//    shareIntent.type = "image/jpeg"
//    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
//
//    try {
//        ContextCompat.startActivity(shareIntent)
//    } catch (ex: ActivityNotFoundException) {
//    }
//
//    val imageUrl = "drawable://" + R.drawable.referral_banner
//    val uri =
//        Uri.parse(imageUrl)
//
//
//    val intent = Intent()
//    intent.action = Intent.ACTION_SEND
//    intent.putExtra(Intent.EXTRA_TEXT, downloadMessage)
//    intent.type = "text/plain"
//    intent.putExtra(Intent.EXTRA_STREAM, uri)
//    intent.type = "image/jpeg"
//    intent.setPackage("com.whatsapp")
//    startActivity(context, intent, null)

}