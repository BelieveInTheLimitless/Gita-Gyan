package com.example.gitagyan.screens.main

import android.annotation.SuppressLint
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavController

@SuppressLint("UnrememberedMutableState", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavController){
    Surface(color = MaterialTheme.colors.background) {

        val currentScreen= mutableStateOf<Screens>(Screens.Home)

        Scaffold(
            bottomBar = {
                CustomBottomNavigation(currentScreenId = currentScreen.value.id) {
                    currentScreen.value=it
                }
            }
        ) {

        }
    }
}
