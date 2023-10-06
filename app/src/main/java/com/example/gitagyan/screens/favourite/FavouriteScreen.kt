package com.example.gitagyan.screens.favourite

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gitagyan.data.english.getEnglishChapters
import com.example.gitagyan.model.Favourite
import com.example.gitagyan.navigation.AppScreens
import com.example.gitagyan.screens.components.topbar.TopBottomBar


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FavouriteScreen(navController: NavController){
    TopBottomBar(navController = navController)
    Box(modifier = Modifier.padding(top = 45.dp, bottom = 45.dp)) {
        FavouriteVerseContent(navController = navController)
    }
}

@Composable
fun FavouriteVerseContent(navController: NavController,
                          favouriteViewModel: FavouriteViewModel = hiltViewModel()
){

    Column(modifier = Modifier.padding(10.dp)) {
        val favouriteList = favouriteViewModel.favList.collectAsState().value
        LazyColumn{
            items(items = favouriteList){
                VerseItem(favourite = it, favouriteViewModel = favouriteViewModel){ chapterId, verseId ->
                    navController.navigate(AppScreens.VerseScreen.name+"/${chapterId}"+"/${verseId}")
                }
            }
        }
    }
}

@Composable
fun VerseItem(
    favourite: Favourite,
    favouriteViewModel: FavouriteViewModel,
    onItemClick: (String, String) -> Unit){

    val chapters = getEnglishChapters()

    val context = LocalContext.current

    Card(modifier = Modifier
        .padding(3.dp)
        .fillMaxWidth()
        .clickable {
            onItemClick((favourite.chapterId.toInt()-1).toString(), (favourite.verseId.toInt()-1).toString())
        },
        shape = RoundedCornerShape(corner = CornerSize(20.dp)),
        backgroundColor = Color(0xFFFD950E),
        contentColor = Color.Black,
        elevation = 7.dp) {
        Row(modifier = Modifier.padding(top = 6.dp, bottom = 6.dp, start = 16.dp, end = 16.dp)
            .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Column(
                modifier = Modifier
                    .padding(5.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = chapters[favourite.chapterId.toInt()-1].chapterName,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.caption
                )
                Text(
                    text = "Chapter ${favourite.chapterId}",
                    color = Color.White,
                    fontWeight = FontWeight.W400,
                    fontSize = 15.sp,
                    style = MaterialTheme.typography.caption
                )
                Text(
                    text = "Verse ${favourite.verseId}",
                    fontWeight = FontWeight.W400,
                    fontSize = 15.sp,
                    style = MaterialTheme.typography.caption,
                    color = Color.White
                )
            }
            Icon(imageVector = Icons.Outlined.Favorite, contentDescription = "Delete",
                modifier = Modifier.clickable {
                    favouriteViewModel
                        .deleteFavourite(favourite)
                    Toast.makeText(
                        context, "Deleted from Favourites",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                tint = Color.White
            )
        }
    }
}