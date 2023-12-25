package com.example.gitagyan.screens.components.bottombar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationItem(
    items: List<BottomNavigationItem>,
    navController: NavController,
    onItemClick: (BottomNavigationItem) -> Unit
    ) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    Row(
        modifier = Modifier
            .background(Color.White)
            .height(60.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {

        items.forEach { item ->
            NavigationItem(item = item,
                item.route == backStackEntry.value?.destination?.route) {
                onItemClick(item)
            }
        }
    }
}

@Composable
fun NavigationItem(item: BottomNavigationItem, isSelected:Boolean, onClick:()->Unit){

    val background=if (isSelected) Color(0xFFFD950E) else Color.White
    val contentColor=if (isSelected) Color.White else Color.Black

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(background)
            .clickable(onClick = onClick)
    ){
        Row(
            modifier=Modifier
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            Icon(
                imageVector = item.icon,
                contentDescription = null,
                tint = contentColor
            )

            AnimatedVisibility(visible = isSelected) {
                Text(
                    text = item.name,
                    color=contentColor
                )
            }
        }
    }
}