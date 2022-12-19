package com.example.gitagyan.screens.icons

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.gitagyan.R

object CustomIcons{
    val Bookmark = R.drawable.ic_bookmark
    val BookmarkBorder = R.drawable.ic_bookmark_border
    val Bookmarks = R.drawable.ic_bookmarks
    val BookmarksBorder = R.drawable.ic_bookmarks_border
    val Home = Icons.Default.Home
    val Search = Icons.Default.Search
    val Profile = Icons.Default.Person
}

sealed class Icon {
    data class ImageVectorIcon(val imageVector: ImageVector) : Icon()
    data class DrawableResourceIcon(@DrawableRes val id: Int) : Icon()
}
