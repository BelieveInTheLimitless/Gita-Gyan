package com.example.gitagyan.screens.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.gitagyan.model.Languages
import com.example.gitagyan.navigation.AppScreens
import com.example.gitagyan.screens.profile.LanguageViewModel

@Composable
fun BottomBar(rootNavController: NavController, languageViewModel: LanguageViewModel = hiltViewModel()){

    val language = languageViewModel.languageList.collectAsState().value

    if (language.isNotEmpty()){
        Languages.selectedLanguage = language[0].language
    }

    val navBackStackEntry by rootNavController.currentBackStackEntryAsState()

    NavigationBar(containerColor = Color.White, tonalElevation = 5.dp) {
        val items = listOf(
            BottomNavigationItem(
                title = if (Languages.selectedLanguage == "English") "Home" else "मुख्य",
                route = AppScreens.HomeScreen.name,
                selectedIcon = Icons.Filled.Home,
                unselectedIcon = Icons.Outlined.Home,
            ),
            BottomNavigationItem(
                title = if (Languages.selectedLanguage == "English") "Search" else "खोज",
                route = AppScreens.SearchScreen.name,
                selectedIcon = Icons.Filled.Search,
                unselectedIcon = Icons.Outlined.Search,
            ),
            BottomNavigationItem(
                title = if (Languages.selectedLanguage == "English") "Favourite" else "पसंदीदा",
                route = AppScreens.FavouriteScreen.name,
                selectedIcon = Icons.Filled.Favorite,
                unselectedIcon = Icons.Outlined.FavoriteBorder,
            ),
            BottomNavigationItem(
                title = if (Languages.selectedLanguage == "English") "Profile" else "प्रोफाइल",
                route = AppScreens.ProfileScreen.name,
                selectedIcon = Icons.Filled.Person,
                unselectedIcon = Icons.Outlined.Person
            )
        )

        items.forEach { item ->
            val isSelected = item.route ==
                    navBackStackEntry?.destination?.route

            NavigationBarItem(
                selected = isSelected,
                label = {
                    Text(text = item.title)
                },
                icon = {
                    Icon(
                        imageVector = if (isSelected) {
                            item.selectedIcon
                        } else item.unselectedIcon,
                        contentDescription = item.title
                    )
                },
                onClick = {
                    rootNavController.navigate(item.route) {
                        popUpTo(rootNavController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    selectedTextColor = Color(0xFFFD950E),
                    indicatorColor = Color(0xFFFD950E),
                    unselectedTextColor = Color.Black,
                    unselectedIconColor = Color.Black
                )
            )
        }
    }
}