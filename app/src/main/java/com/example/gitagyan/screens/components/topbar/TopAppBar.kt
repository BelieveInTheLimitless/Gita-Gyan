package com.example.gitagyan.screens.components.topbar

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gitagyan.screens.components.bottombar.BottomNavigation
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TopAppBar(navController:NavController){
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color(0xFFFD950E)) {
                Spacer(modifier = Modifier.padding(start = 145.dp))
                Text(text = "Gita Gyan",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif
                )
            }
        },
        bottomBar = {
            BottomNavigation(navController = navController)
        },
        backgroundColor = Color(0xFFFF9100)
    ){
        Box(modifier = Modifier.padding(0.dp))
    }
}