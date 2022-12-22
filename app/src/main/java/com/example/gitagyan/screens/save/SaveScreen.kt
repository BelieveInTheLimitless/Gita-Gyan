package com.example.gitagyan.screens.save

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gitagyan.screens.components.topbar.TopAppBar

@Composable
fun SaveScreen(navController: NavController){
    TopAppBar(navController = navController)
    Box(modifier = Modifier.padding(top = 60.dp, bottom = 60.dp)) {
        Search()
    }
}

@Composable
fun Search(){
    Column() {
        Surface(modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(corner = CornerSize(10.dp)),
            color = Color.White) {
            Text(text = "Favourites Screen",
                color = Color.Black,
                modifier = Modifier.padding(top = 275.dp),
                fontSize = 25.sp,
                textAlign = TextAlign.Center)
        }
    }
}