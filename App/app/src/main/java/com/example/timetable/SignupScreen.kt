package com.example.timetable

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.timetable.ui.theme.TimetableTheme

@Composable
fun SignUpScreen(onSignUpClicked:(String,String,String,String)->Unit,
                 signInNavigation:()->Unit,
//                 signUpWithGoogle:()->Unit,
//                 errorMessage: String?,
                 context: Context = LocalContext.current) {


    TimetableTheme {
        var userName by rememberSaveable {
            mutableStateOf("")
        }
        var userEmail by rememberSaveable {
            mutableStateOf("")
        }
        var userPassword by rememberSaveable {
            mutableStateOf("")
        }
        var confirmUserPassword by rememberSaveable {
            mutableStateOf("")
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 8.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.person),
                    contentDescription = null,
                    modifier = Modifier.size(180.dp),
                )

                Spacer(modifier = Modifier.height(25.dp))

                ScreenTextField(
                    label = "Name",
                    text = userName,
                    hint = "Enter Name",
                    leadingIcon = Icons.Outlined.Face,
                    false){
                    userName = it
                }

                Spacer(modifier = Modifier.height(4.dp))

                ScreenTextField(
                    label = "Email",
                    text = userEmail,
                    hint = "Enter Email",
                    leadingIcon = Icons.Outlined.Email,
                    false){
                    userEmail = it
                }

                ScreenTextField(
                    label = "Password",
                    text = userPassword,
                    hint = "Enter Password",
                    leadingIcon = Icons.Outlined.Lock,
                    true){
                    userPassword = it
                }

                ScreenTextField(
                    label = "Confirm Password",
                    text = userPassword,
                    hint = "Enter Password again",
                    leadingIcon = Icons.Outlined.Lock,
                    true){
                    confirmUserPassword = it
                }

                Button(
                    modifier = Modifier
                        .padding( 20.dp),
                    shape = RoundedCornerShape(25.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                    onClick = {
                        //                    showToast(context = context, message = "Click: Button")
                    }) {
                    Text(
                        text ="Signup",
                        style = TextStyle(
                            fontSize = 18.sp,
                        )
                    )
                }
                Row() {
                    Text(
                        text ="Already hava an account? ",
                        style = TextStyle(
                            fontSize = 18.sp,
                        )
                    )

                    Text(
                        text = "Login",
                        color = Color.Red
                    )
                }
            }

        }
    }

}