package com.example.gitagyan.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gitagyan.screens.splash.SplashScreen
import com.example.gitagyan.screens.components.bottombar.BottomNavigationBar
import com.example.gitagyan.screens.search.SearchScreen
import com.example.gitagyan.screens.save.SaveScreen
import com.example.gitagyan.screens.profile.ProfileScreen
import com.example.gitagyan.screens.settings.SettingsScreen
import com.example.gitagyan.screens.home.HomeScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.name){

        composable(AppScreens.SplashScreen.name){
            SplashScreen(navController = navController)
        }

        composable(AppScreens.MainScreen.name){
            BottomNavigationBar(navController = navController)
        }

        composable(AppScreens.HomeScreen.name){
            HomeScreen(navController = navController)
        }

        composable(AppScreens.SearchScreen.name){
            SearchScreen(navController = navController)
        }

        composable(AppScreens.SaveScreen.name){
            SaveScreen(navController = navController)
        }

        composable(AppScreens.ProfileScreen.name){
            ProfileScreen(navController = navController)
        }

        composable(AppScreens.SettingsScreen.name){
            SettingsScreen(navController = navController)
        }

    }
}