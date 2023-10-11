package com.example.gitagyan.screens.components.bottombar

import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigation
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gitagyan.data.content.Language
import com.example.gitagyan.navigation.AppScreens


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BottomNavigationBar(navController: NavController){
    val homeScreenLanguage = if (Language.selectedLanguage == "English") "Home" else "मुख्य"
    val searchScreenLanguage = if (Language.selectedLanguage == "English") "Search" else "खोज"
    val favouriteScreenLanguage = if (Language.selectedLanguage == "English") "Favourite" else "पसंदीदा"
    val profileScreenLanguage = if (Language.selectedLanguage == "English") "Profile" else "प्रोफाइल"
    BottomNavigation(elevation = 10.dp) {
        BottomNavigationItem(
            items = listOf(
                BottomNavigationItem(
                    name = homeScreenLanguage,
                    route = AppScreens.HomeScreen.name,
                    icon = Icons.Default.Home
                ),
                BottomNavigationItem(
                    name = searchScreenLanguage,
                    route = AppScreens.SearchScreen.name,
                    icon = Icons.Default.Search
                ),
                BottomNavigationItem(
                    name = favouriteScreenLanguage,
                    route = AppScreens.FavouriteScreen.name,
                    icon = Icons.Default.Favorite
                ),
                BottomNavigationItem(
                    name = profileScreenLanguage,
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
}

