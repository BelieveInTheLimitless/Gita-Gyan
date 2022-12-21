package com.example.gitagyan.screens.components.bottombar

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.gitagyan.navigation.AppScreens


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BottomNavigation(navController: NavController){
    BottomNavigationItem(
        items = listOf(
            BottomNavigationItem(
                name = "Home",
                route = AppScreens.HomeScreen.name,
                icon = Icons.Default.Home
            ),
            BottomNavigationItem(
                name = "Search",
                route = AppScreens.SearchScreen.name,
                icon = Icons.Default.Search
            ),
            BottomNavigationItem(
                name = "Saved",
                route = AppScreens.SaveScreen.name,
                icon = Icons.Default.Favorite
            ),
            BottomNavigationItem(
                name = "Profile",
                route = AppScreens.ProfileScreen.name,
                icon = Icons.Default.Person
            )
        ),
        navController = navController,
        onItemClick = {
            navController.navigate(it.route)
        }
    )
}

