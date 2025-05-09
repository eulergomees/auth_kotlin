package com.eulergomees.login_kotlin_firebase

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Password
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eulergomees.login_kotlin_firebase.ui.theme.LoginkotlinfirebaseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginkotlinfirebaseTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AuthScreen(
                        onEnterClick = {
                            Log.i("MainActivity", "User: $it")
                        }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthScreen(onEnterClick: (User) -> Unit = {}) {
    Column(modifier = Modifier.padding(
        top = 16.dp,
        bottom = 16.dp
    )) {
        var username by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }

        TextField(
            value = username,
            onValueChange = { newValue ->
                username = newValue
            },
            Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            label = { Text("Username") },
            leadingIcon = {
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "User")
            }
        )
        TextField(
            value = password,
            onValueChange = { newValue -> password = newValue },
            Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            label = { Text("Password") },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Password, contentDescription = "Password")
            },
            visualTransformation = PasswordVisualTransformation(),
        )

        Button(
            onClick = {
                onEnterClick(
                    User(
                        username,
                        password
                    )
                )
            },
            Modifier
                .padding(8.dp)
                .fillMaxWidth(),
        ) {
            Text(text = "Login")
        }
    }
}

@Preview
@Composable
private fun AuthScreenPreview() {
    LoginkotlinfirebaseTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            AuthScreen(onEnterClick = {})
        }
    }
}
