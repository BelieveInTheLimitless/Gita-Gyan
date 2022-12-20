package com.example.gitagyan.screens.components.topbar

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TopAppBar(navController:NavController){
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color(0xFFFD950E)) {
                Surface(modifier = Modifier.fillMaxSize().padding(vertical = 13.dp),
                color = Color(0xFFFD950E)) {
                    Text(text = "Gita Gyan",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                        textAlign = TextAlign.Center
                    )
                    Row(horizontalArrangement = Arrangement.End) {
                        Icon(imageVector = Icons.Default.Settings,
                            contentDescription = "Settings",
                            modifier = Modifier
                                .clickable { },
                            tint = Color.Black)
                    }
                }

            }
        }
    ) {
        BottomNavigation(navController = navController)
    }
}