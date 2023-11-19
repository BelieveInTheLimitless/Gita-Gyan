package com.example.gitagyan.screens.home

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gitagyan.R
import com.example.gitagyan.data.content.Chapter
import com.example.gitagyan.model.Languages
import com.example.gitagyan.data.content.english.getEnglishChapters
import com.example.gitagyan.data.content.hindi.getHindiChapters
import com.example.gitagyan.model.Favourite
import com.example.gitagyan.screens.components.topbar.TopBottomBar
import com.example.gitagyan.screens.favourite.FavouriteViewModel

@Composable
fun VerseScreen(navController: NavController, favouriteViewModel: FavouriteViewModel = hiltViewModel(), chapterId: String?, verseId: String?) {
    val chapters = if (Languages.selectedLanguage == "English") getEnglishChapters() else getHindiChapters()
    TopBottomBar(navController = navController)
    Box(modifier = Modifier.padding(top = 60.dp, bottom = 60.dp)) {
        if (chapterId != null) {
            if (verseId != null) {
                Verses(favouriteViewModel, chapter = chapters[chapterId.toInt()],
                    verseId = verseId
                )
            }
        }
    }
}


@SuppressLint("UnrememberedMutableState")
@Composable
fun Verses(favouriteViewModel: FavouriteViewModel = hiltViewModel(), chapter: Chapter, verseId: String) {

    var id by remember {
        mutableIntStateOf(verseId.toInt())
    }

    val isAlreadyFavourite = favouriteViewModel.favList.collectAsState().value.filter { item ->
        (item.chapterId.toString() == chapter.chapterId) && ((item.verseId - 1) == id)
    }

    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFFD950E)
    ) {
        Surface(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxSize(),
            shape = RoundedCornerShape(corner = CornerSize(40.dp)),
            color = Color.White,
            contentColor = Color.Black
        ) {
            Row(
                Modifier.padding(top = 45.dp, bottom = 45.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Column(
                    modifier = Modifier.padding(10.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.krishna_arjuna),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds
                    )

                    Spacer(modifier = Modifier.padding(5.dp))

                    Text(
                        text = chapter.chapterName,
                        modifier = Modifier.padding(top = 10.dp),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.W600,
                        style = MaterialTheme.typography.h4,
                        textAlign = TextAlign.Center
                    )

                    Row(
                        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (id == 0) {
                            Card(
                                modifier = Modifier
                                    .size(35.dp),
                                shape = RoundedCornerShape(corner = CornerSize(35.dp)),
                                backgroundColor = Color.White,
                                contentColor = Color.LightGray,
                                elevation = 5.dp
                            ) {
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowLeft,
                                    contentDescription = null
                                )
                            }
                        } else {
                            Card(
                                modifier = Modifier
                                    .size(35.dp)
                                    .clickable(onClick = {
                                        id -= 1
                                    }),
                                shape = RoundedCornerShape(corner = CornerSize(35.dp)),
                                backgroundColor = Color.White,
                                contentColor = Color.Black,
                                elevation = 5.dp
                            ) {
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowLeft,
                                    contentDescription = null
                                )
                            }
                        }

                        Text(
                            text = chapter.chapterContent[id].verseName,
                            modifier = Modifier.padding(start = 90.dp, end = 90.dp),
                            color = Color(0xFFFD950E),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 20.sp,
                            style = MaterialTheme.typography.caption
                        )

                        if (id == chapter.chapterContent.size - 1) {
                            Card(
                                modifier = Modifier
                                    .size(35.dp),
                                shape = RoundedCornerShape(corner = CornerSize(35.dp)),
                                backgroundColor = Color.White,
                                contentColor = Color.LightGray,
                                elevation = 5.dp
                            ) {
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowRight,
                                    contentDescription = null
                                )
                            }
                        } else {
                            Card(
                                modifier = Modifier
                                    .size(35.dp)
                                    .clickable(onClick = {
                                        id += 1
                                    }),
                                shape = RoundedCornerShape(corner = CornerSize(35.dp)),
                                backgroundColor = Color.White,
                                contentColor = Color.Black,
                                elevation = 5.dp
                            ) {
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowRight,
                                    contentDescription = null
                                )
                            }
                        }
                    }

                    if (isAlreadyFavourite.isNotEmpty()) {
                        IconButton(
                            onClick = {
                                favouriteViewModel.deleteFavourite(
                                    Favourite(
                                        chapterId = chapter.chapterId.toInt(),
                                        verseId = id + 1
                                    )
                                )
                                Toast.makeText(
                                    context, if (Languages.selectedLanguage == "English") "Deleted from Favourites" else "पसंदीदा से हटा दिया गया",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Favorite,
                                contentDescription = "Favourites Icon"
                            )
                        }
                    }
                    else{
                        IconButton(
                            onClick = {
                                favouriteViewModel.insertFavourite(
                                    Favourite(
                                        chapterId = chapter.chapterId.toInt(),
                                        verseId = id + 1
                                    )
                                )
                                Toast.makeText(
                                    context, if (Languages.selectedLanguage == "English") "Added to Favourites" else "पसंदीदा में जोड़ा गया",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.FavoriteBorder,
                                contentDescription = "Favourites Icon"
                            )
                        }
                    }

                    Spacer(modifier = Modifier.padding(5.dp))

                    Column(
                        modifier = Modifier
                            .verticalScroll(state = ScrollState(0)),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = chapter.chapterContent[id].verse,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.W600,
                            style = MaterialTheme.typography.caption,
                            textAlign = TextAlign.Center
                        )

                        Text(
                            text = chapter.chapterContent[id].verseMeaning,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.W400,
                            style = MaterialTheme.typography.caption,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}