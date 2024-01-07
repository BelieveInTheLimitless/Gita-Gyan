package com.example.gitagyan.screens.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gitagyan.navigation.AppScreens
import com.example.gitagyan.screens.favourite.FavouriteNavHost
import com.example.gitagyan.screens.home.HomeNavHost
import com.example.gitagyan.screens.profile.ProfileNavHost
import com.example.gitagyan.screens.search.SearchNavHost

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppNavigation(){

    val rootNavController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomBar(rootNavController = rootNavController)
        },
        containerColor = Color(0xFFFD950E)
    ) {
        NavHost(navController = rootNavController,
            startDestination = AppScreens.HomeScreen.name,
            modifier = Modifier.padding(it)
        ) {
            composable(AppScreens.HomeScreen.name) {
                HomeNavHost()
            }
            composable(AppScreens.SearchScreen.name) {
                SearchNavHost(rootNavController = rootNavController)
            }
            composable(AppScreens.FavouriteScreen.name) {
                FavouriteNavHost(rootNavController = rootNavController)
            }
            composable(AppScreens.ProfileScreen.name) {
                ProfileNavHost(rootNavController = rootNavController)
            }
        }
    }
}