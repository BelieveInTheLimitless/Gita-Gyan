package com.example.gitagyan.screens.components.topbar

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.unit.dp
import com.example.gitagyan.screens.components.bottombar.BottomNavigationBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TopAppBar(navController:NavController){
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color(0xFFFFFFFF)) {
                Spacer(modifier = Modifier.padding(start = 145.dp))
                Text(text = "Gita Gyan",
                    color = Color(0xFF000000),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                    style = MaterialTheme.typography.caption
                )
            }
        },
        bottomBar = {
            BottomNavigationBar(navController = navController)
        },
        backgroundColor = Color(0xFFFFFFFF)
    ){
        Box(modifier = Modifier.padding(0.dp))
    }
}