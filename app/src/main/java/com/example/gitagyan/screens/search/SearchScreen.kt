package com.example.gitagyan.screens.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.gitagyan.screens.main.MainScreen

@Composable
fun SearchScreen(navController: NavController){
    MainScreen(navController = navController)
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(text = "Search Screen")
    }
}