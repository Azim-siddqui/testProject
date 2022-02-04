package com.example.istjetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.istjetpackcomposeapp.ui.theme.IstJetPackComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IstJetPackComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(text = "Test App")
                                },
                                navigationIcon = {
                                    IconButton(onClick = {}) {
                                        Icon(Icons.Filled.Menu, contentDescription = "menu")
                                    }
                                },
                                actions = {
                                    IconButton(onClick = {}) {
                                        Icon(
                                            Icons.Filled.Notifications,
                                            contentDescription = "menu"
                                        )
                                    }
                                    IconButton(onClick = {}) {
                                        Icon(Icons.Filled.Search, contentDescription = "menu")
                                    }
                                    IconButton(onClick = {}) {
                                        Icon(
                                            Icons.Filled.AccountCircle,
                                            contentDescription = "menu"
                                        )
                                    }
                                }

                            )
                        },
                        floatingActionButton = {
                            FloatingActionButton(onClick = { }) {
                                IconButton(onClick = {}) {
                                    Icon(Icons.Filled.Add, contentDescription = "menu")
                                }
                            }
                        }
                        //to center position
                        // floatingActionButtonPosition = FabPosition.Center
                    ) {
                        Greeting("Android")
                       // showSwitch()
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
   // Text(text = "Hello $name!")
    TextField(value = "Type here..", onValueChange = {})
}

@Composable
fun showSwitch() {
    val isChecked = remember {
        mutableStateOf(true)
    }
    Switch(checked = isChecked.value,
        onCheckedChange = { isChecked.value = it },
        modifier = Modifier.run {
            size(20.dp)
            padding(5.dp)
        })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IstJetPackComposeAppTheme {
        Greeting("Android")
    }
}