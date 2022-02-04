package com.example.istjetpackcomposeapp.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.istjetpackcomposeapp.MainActivity
import com.example.istjetpackcomposeapp.ui.theme.IstJetPackComposeAppTheme

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IstJetPackComposeAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    LoginForm()
                }

            }
        }
    }

    @Composable
    fun LoginForm() {

        val userName = remember { mutableStateOf("") }
        val userPassword = remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Hey Welcome",
                color = Color.Red,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive,
            )
            OutlinedTextField(
                value = userName.value,
                onValueChange = {
                    userName.value = it
                },
                leadingIcon = { Icon(Icons.Default.Person, contentDescription = "person") },
                label = { Text(text = "Username") },
                placeholder = { Text(text = "enter username") },
                modifier = Modifier.fillMaxWidth(),
                enabled = true
            )
            OutlinedTextField(
                value = userPassword.value,
                onValueChange = {
                    userPassword.value = it
                },
                leadingIcon = { Icon(Icons.Default.Info, contentDescription = "person") },
                label = { Text(text = "Password") },
                placeholder = { Text(text = "enter password") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedButton(
                onClick = {logged(userName.value,userPassword.value)},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)) {
                Text(text = "Login")
            }
        }
    }


    private fun logged(username: String, password: String) {
        if (username == "admin" && password == "1234"){
            Toast.makeText(this, "Login succesfully", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,MainActivity::class.java))
        }
        else
            Toast.makeText(this, "invalid credentials", Toast.LENGTH_SHORT).show()
    }
}