package com.example.gitagyan.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gitagyan.screens.components.details.Details
import com.example.gitagyan.screens.components.topbar.BasicTopBar

@Composable
fun DetailsScreen(navController: NavController){
    BasicTopBar(navController = navController)
    Box(modifier = Modifier.padding(top = 45.dp)) {
        Details()
    }
}

