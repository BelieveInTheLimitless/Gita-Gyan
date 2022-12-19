package com.example.gitagyan.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.gitagyan.screens.main.MainScreen

@Composable
fun HomeScreen(navController: NavController){
    MainScreen(navController = navController)
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(text = "Home Screen")
    }

}