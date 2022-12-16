package com.example.gitagyan.screens.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screens(
    val id:String,
    val title:String,
    val icon: ImageVector,
){



    object Home:Screens("home","Home", Icons.Outlined.Home)
    object Search:Screens("search","Search",Icons.Outlined.Search)
    object Saved:Screens("saved","Saved", Icons.Default.FavoriteBorder)
    object Profile:Screens("profile","Profile",Icons.Outlined.Person)

    object Items{
        val list= listOf(
            Home,Search,Saved,Profile
        )
    }

}
