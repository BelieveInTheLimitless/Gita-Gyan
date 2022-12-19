package com.example.gitagyan.screens.main

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.gitagyan.navigation.AppScreens


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavController){
    Scaffold(
        bottomBar = {
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
                        name = "Settings",
                        route = AppScreens.SaveScreen.name,
                        icon = Icons.Default.MailOutline
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
    ) {
    }
}

