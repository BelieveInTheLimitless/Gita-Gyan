package com.example.gitagyan.screens.components.topbar

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.unit.dp
import com.example.gitagyan.model.Languages
import com.example.gitagyan.navigation.AppScreens
import com.example.gitagyan.screens.components.bottombar.BottomNavigationItem

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TopBottomBar(
    navController:NavController,
    backgroundColor: Color,
    isMainScreen: Boolean = false,
    content: @Composable () -> Unit){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(backgroundColor = Color.White) {
                val appName = if (Languages.selectedLanguage == "English") "Gita Gyan" else "गीता ज्ञान"
                if (!isMainScreen) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        IconButton(onClick = {
                            navController.popBackStack()
                        }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back Arrow"
                            )
                        }

                        Text(
                            text = appName,
                            modifier = Modifier.padding(start = 90.dp),
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Serif,
                            style = MaterialTheme.typography.caption
                        )
                    }
                }
                else{
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically) {
                        Text(text = appName,
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Serif,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.caption
                        )
                    }
                }
            }
        },
        bottomBar = {
            val homeScreenLanguage = if (Languages.selectedLanguage == "English") "Home" else "मुख्य"
            val searchScreenLanguage = if (Languages.selectedLanguage == "English") "Search" else "खोज"
            val favouriteScreenLanguage = if (Languages.selectedLanguage == "English") "Favourite" else "पसंदीदा"
            val profileScreenLanguage = if (Languages.selectedLanguage == "English") "Profile" else "प्रोफाइल"

            BottomNavigation(modifier = Modifier.fillMaxWidth(), elevation = 10.dp) {
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
        },
        backgroundColor = backgroundColor
    ){
        Box(modifier = Modifier.padding(it)) {
            content()
        }
    }
}