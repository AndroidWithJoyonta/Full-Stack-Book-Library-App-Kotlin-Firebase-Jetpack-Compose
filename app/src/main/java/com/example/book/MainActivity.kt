package com.example.book

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.book.presentation.Navigation.NavGraph
import com.example.book.ui.theme.BookTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BookTheme {

                MainScrern()
            }


        }
    }
}

@Composable
fun MainScrern() {

    val showSplash = remember {
        mutableStateOf(true)
    }

    LaunchedEffect (Unit){

        Handler(Looper.getMainLooper()).postDelayed({
            showSplash.value = false
        },3000)
    }

    if (showSplash.value){

        SplashScreen()

    }else{
        NavGraph()
    }



}

@Composable
fun SplashScreen(modifier: Modifier = Modifier) {

    Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center){

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(painter = painterResource(R.drawable.logo),"",modifier.size(200.dp))

            Spacer(Modifier.height(10.dp))
            BasicText("Welcome to Book library", style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold))

        }
    }

}
