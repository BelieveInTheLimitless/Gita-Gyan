package com.example.gitagyan.screens.favourite

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gitagyan.model.Languages
import com.example.gitagyan.data.content.english.getEnglishChapters
import com.example.gitagyan.data.content.hindi.getHindiChapters
import com.example.gitagyan.model.Favourite
import com.example.gitagyan.navigation.AppScreens
import com.example.gitagyan.screens.components.topbar.TopBottomBar


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FavouriteScreen(navController: NavController){
    TopBottomBar(navController = navController, backgroundColor = Color.White){
        FavouriteVerseContent(navController = navController)
    }
}

@Composable
fun FavouriteVerseContent(navController: NavController,
                          favouriteViewModel: FavouriteViewModel = hiltViewModel()
){
    val favouriteList = favouriteViewModel.favList.collectAsState().value
    if(favouriteList.isEmpty()){
        Column(modifier = Modifier
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = if (Languages.selectedLanguage == "English") "Favourites list empty" else "पसंदीदा सूची खाली",
                fontWeight = FontWeight.W400,
                fontSize = 20.sp,
                style = MaterialTheme.typography.caption,
            )
        }
    }
    else{
        LazyColumn(modifier = Modifier
            .padding(5.dp)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top){
            items(items = favouriteList){
                VerseItem(favourite = it, favouriteViewModel = favouriteViewModel){ chapterId, verseId ->
                    navController.navigate(AppScreens.VerseScreen.name+"/${chapterId}"+"/${verseId}"+"/${false}")
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VerseItem(
    favourite: Favourite,
    favouriteViewModel: FavouriteViewModel,
    onItemClick: (String, String) -> Unit){

    val chapters = if (Languages.selectedLanguage == "English") getEnglishChapters() else getHindiChapters()

    val context = LocalContext.current

    Card(modifier = Modifier
        .padding(3.dp)
        .fillMaxWidth()
        .clickable {
            onItemClick(
                (favourite.chapterId - 1).toString(),
                (favourite.verseId - 1).toString()
            )
        },
        shape = RoundedCornerShape(corner = CornerSize(20.dp)),
        backgroundColor = Color(0xFFFD950E),
        contentColor = Color.Black,
        elevation = 5.dp) {
        Row(modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
                    .weight(0.9F),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = chapters[favourite.chapterId-1].chapterName,
                    modifier = Modifier.basicMarquee(),
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.caption,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Text(
                    text = chapters[favourite.chapterId-1].chapter,
                    color = Color.White,
                    fontWeight = FontWeight.W400,
                    fontSize = 15.sp,
                    style = MaterialTheme.typography.caption
                )
                Text(
                    text = chapters[favourite.chapterId-1].chapterContent[favourite.verseId-1].verseName,
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
                        context, if (Languages.selectedLanguage == "English") "Deleted from Favourites" else "पसंदीदा से हटा दिया गया",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                tint = Color.White
            )
        }
    }
}
