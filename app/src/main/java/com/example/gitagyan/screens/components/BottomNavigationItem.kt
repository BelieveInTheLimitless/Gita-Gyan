package com.example.gitagyan.screens.components

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val title: String,
    val route: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector
)
