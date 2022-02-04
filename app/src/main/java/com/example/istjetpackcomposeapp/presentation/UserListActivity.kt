package com.example.istjetpackcomposeapp.presentation

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.istjetpackcomposeapp.R
import com.example.istjetpackcomposeapp.data.model.User
import com.example.istjetpackcomposeapp.presentation.post.compose.UserCard
import com.example.istjetpackcomposeapp.ui.theme.IstJetPackComposeAppTheme

class UserListActivity : ComponentActivity() {

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IstJetPackComposeAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val list = ArrayList<User>()
                    list.add(User(R.drawable.girl,"Radhika"))
                    list.add(User(R.drawable.girl,"Radhika"))
                    list.add(User(R.drawable.girl,"Radhika"))
                    list.add(User(R.drawable.girl,"Radhika"))
                    list.add(User(R.drawable.girl,"Radhika"))
                    list.add(User(R.drawable.girl,"Radhika"))
                    list.add(User(R.drawable.girl,"Radhika"))
                    list.add(User(R.drawable.girl,"Radhika"))
                    list.add(User(R.drawable.girl,"Radhika"))
                    list.add(User(R.drawable.girl,"Radhika"))
                    list.add(User(R.drawable.girl,"Radhika"))
                    list.add(User(R.drawable.girl,"Radhika"))
                    list.add(User(R.drawable.girl,"Radhika"))
                    list.add(User(R.drawable.girl,"Radhika"))
                    list.add(User(R.drawable.girl,"Radhika"))
                    list.add(User(R.drawable.girl,"Radhika"))
                    list.add(User(R.drawable.girl,"Radhika"))
                    list.add(User(R.drawable.girl,"Radhika"))
                    RecyclerView(users = list)
                }
            }
        }
    }

    @Composable
    fun EachRow(user : User) {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(CornerSize(2.dp)),
            elevation = 2.dp
        ) {
            Column(modifier = Modifier.padding(0.dp)) {
                Image(
                    painter = painterResource(id = user.image),
                    contentDescription = "image",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .height(100.dp)
                        .fillMaxWidth()
                )
                Text(text = user.name, modifier = Modifier
                    .padding(5.dp)
                    .align(Alignment.CenterHorizontally))
            }

        }
    }

    @ExperimentalFoundationApi
    @Composable
    fun RecyclerView(users:List<User>) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(2)
        ) {
            items(users) { user ->
               // EachRow(user)
                UserCard()
            }
        }
    }

    @ExperimentalFoundationApi
    @Preview(showBackground = true)
    @Composable
    fun Default(){
        val list = ArrayList<User>()
        list.add(User(R.drawable.girl,"Radhika"))
        list.add(User(R.drawable.girl,"Radhika"))
        list.add(User(R.drawable.girl,"Radhika"))
        list.add(User(R.drawable.girl,"Radhika"))
        list.add(User(R.drawable.girl,"Radhika"))
        list.add(User(R.drawable.girl,"Radhika"))
        list.add(User(R.drawable.girl,"Radhika"))
        list.add(User(R.drawable.girl,"Radhika"))
        list.add(User(R.drawable.girl,"Radhika"))
        list.add(User(R.drawable.girl,"Radhika"))
        list.add(User(R.drawable.girl,"Radhika"))
        list.add(User(R.drawable.girl,"Radhika"))
        list.add(User(R.drawable.girl,"Radhika"))
        list.add(User(R.drawable.girl,"Radhika"))
        list.add(User(R.drawable.girl,"Radhika"))
        list.add(User(R.drawable.girl,"Radhika"))
        list.add(User(R.drawable.girl,"Radhika"))
        list.add(User(R.drawable.girl,"Radhika"))
        RecyclerView(users = list)
    }
}