package com.example.gitagyan.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.gitagyan.screens.splash.SplashScreen
import com.example.gitagyan.screens.components.bottombar.BottomNavigationBar
import com.example.gitagyan.screens.favourite.FavouriteScreen
import com.example.gitagyan.screens.favourite.FavouriteViewModel
import com.example.gitagyan.screens.home.DetailsScreen
import com.example.gitagyan.screens.search.SearchScreen
import com.example.gitagyan.screens.profile.ProfileScreen
import com.example.gitagyan.screens.home.HomeScreen
import com.example.gitagyan.screens.home.VerseScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.name){

        composable(AppScreens.SplashScreen.name){
            SplashScreen(navController = navController)
        }

        composable(AppScreens.BottomNavigation.name){
            BottomNavigationBar(navController = navController)
        }

        composable(AppScreens.HomeScreen.name){
            HomeScreen(navController = navController)
        }

        composable(
            AppScreens.DetailsScreen.name+"/{chapter_id}",
            arguments = listOf(navArgument(name = "chapter_id") {type = NavType.StringType})
        ){
                backStackEntry ->
            DetailsScreen(navController = navController, chapterId = backStackEntry.arguments?.getString("chapter_id"))
        }

        composable(
            AppScreens.VerseScreen.name+"/{chapter_id}"+"/{verse_id}",
            arguments = listOf(navArgument(name = "chapter_id") {type = NavType.StringType},
                navArgument(name = "verse_id") { type = NavType.StringType}
            )
        ){
                backStackEntry ->

            val favouriteViewModel = hiltViewModel<FavouriteViewModel>()

            VerseScreen(
                navController = navController,
                favouriteViewModel = favouriteViewModel,
                chapterId = backStackEntry.arguments?.getString("chapter_id"),
                verseId = backStackEntry.arguments?.getString("verse_id")
            )
        }

        composable(AppScreens.SearchScreen.name){
            SearchScreen(navController = navController)
        }

        composable(AppScreens.FavouriteScreen.name){
            FavouriteScreen(navController = navController)
        }

        composable(AppScreens.ProfileScreen.name){
            ProfileScreen(navController = navController)
        }
    }
}