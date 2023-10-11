package com.example.gitagyan.screens.components.topbar

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.unit.dp
import com.example.gitagyan.data.content.Language
import com.example.gitagyan.screens.components.bottombar.BottomNavigationBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TopBottomBar(navController:NavController,
                 isMainScreen: Boolean = false){
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color(0xFFFFFFFF)) {

                Row(modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically) {
                    val appName = if (Language.selectedLanguage == "English") "Gita Gyan" else "   गीता ज्ञान"
                    if (!isMainScreen){
                        IconButton(onClick = {
                            navController.popBackStack()
                        }) {
                            Icon(imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back Arrow")
                        }

                        Text(text = appName,
                            modifier = Modifier.padding(start = 90.dp),
                            color = Color(0xFF000000),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Serif,
                            style = MaterialTheme.typography.caption
                        )
                    }
                    else{
                        Text(text = appName,
                            modifier = Modifier.padding(start = 138.dp),
                            color = Color(0xFF000000),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Serif,
                            style = MaterialTheme.typography.caption
                        )
                    }
                }
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