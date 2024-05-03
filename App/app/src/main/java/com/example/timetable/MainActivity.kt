package com.example.timetable

import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.timetable.ui.theme.TimetableTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TimetableTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "login") {
                    composable("login") {
                        LoginScreen(
                            onLoginClicked = {username,password ->

                            },
                            signUpNavigation = {
                                navController.navigate("signup") {
                                    popUpTo("login") {
                                        inclusive = true
                                    }
                                }
                            },
                            this@MainActivity
                        )
                    }
                    composable("signup") {
                        SignUpScreen(
                            onSignUpClicked = { username, email, password, confirmPassword ->
                            },
                            signInNavigation = {
                                navController.navigate("login") {
                                    popUpTo("signup") {
                                        inclusive = true
                                    }
                                }
                            },
                            )
                    }
                }
            }
        }
    }
}