package com.example.gitagyan.screens.home

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
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
import com.example.gitagyan.R
import com.example.gitagyan.data.content.Chapter
import com.example.gitagyan.model.Languages
import com.example.gitagyan.data.content.english.getEnglishChapters
import com.example.gitagyan.data.content.hindi.getHindiChapters
import com.example.gitagyan.model.CurrentVerse
import com.example.gitagyan.model.Favourite
import com.example.gitagyan.screens.favourite.FavouriteViewModel

@Composable
fun VerseScreen(favouriteViewModel: FavouriteViewModel = hiltViewModel(),
                currentVerseViewModel: CurrentVerseViewModel = hiltViewModel(),
                chapterId: String?,
                verseId: String?,
                isMainScreen: Boolean?) {

    val chapters = if (Languages.selectedLanguage == "English") getEnglishChapters() else getHindiChapters()

    val currentVerseList = currentVerseViewModel.currentVerseList.collectAsState().value

    if(currentVerseList.isNotEmpty() && currentVerseList[0].chapterId-1 == chapterId?.toInt()){
        Verses(favouriteViewModel = favouriteViewModel,
            currentVerseViewModel = currentVerseViewModel,
            chapter = chapters[chapterId.toInt()],
            verseId = (currentVerseList[0].verseId-1).toString(),
            isMainScreen = isMainScreen
        )
    }
    else{
        Verses(favouriteViewModel = favouriteViewModel,
            currentVerseViewModel = currentVerseViewModel,
            chapter = chapters[chapterId!!.toInt()],
            verseId = verseId!!,
            isMainScreen = isMainScreen
        )
    }
}

@Composable
fun Verses(
    favouriteViewModel: FavouriteViewModel,
    currentVerseViewModel: CurrentVerseViewModel,
    chapter: Chapter,
    verseId: String,
    isMainScreen: Boolean?) {

    var id by remember {
        mutableIntStateOf(verseId.toInt())
    }

    val currentVerseList = currentVerseViewModel.currentVerseList.collectAsState().value

    if (isMainScreen == true){
        if (currentVerseList.isNotEmpty()){
            currentVerseViewModel.deleteAllCurrentVerses()
            currentVerseViewModel.insertCurrentVerse(
                CurrentVerse(
                    chapterId = chapter.chapterId.toInt(),
                verseId = id + 1)
            )
        }
        else{
            currentVerseViewModel.insertCurrentVerse(
                CurrentVerse(
                    chapterId = chapter.chapterId.toInt(),
                    verseId = id + 1)
            )
        }
    }

    val isAlreadyFavourite = favouriteViewModel.favList.collectAsState().value.filter { item ->
        (item.chapterId.toString() == chapter.chapterId) && ((item.verseId - 1) == id)
    }

    val context = LocalContext.current

    Column(modifier = Modifier
        .padding(15.dp)
        .fillMaxSize()
        .background(color = Color.White, shape = RoundedCornerShape(corner = CornerSize(40.dp))),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.main_icon),
                contentDescription = "Main Image",
                modifier = Modifier
                    .padding(top = 50.dp, start = 50.dp, end = 50.dp)
                    .aspectRatio(640.dp / 640.dp),
                contentScale = ContentScale.FillWidth
            )

            Spacer(modifier = Modifier.padding(5.dp))

            Text(
                text = chapter.chapter,
                color = Color(0xFFFD950E),
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.caption
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalArrangement = Arrangement.SpaceBetween
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
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = null
                        )
                    }
                } else {
                    Card(
                        modifier = Modifier
                            .size(35.dp)
                            .clickable(onClick = {
                                id -= 1
                                if (isMainScreen == true) {
                                    if (currentVerseList.isEmpty()) {
                                        currentVerseViewModel.deleteAllCurrentVerses()
                                        currentVerseViewModel.insertCurrentVerse(
                                            CurrentVerse(
                                                chapterId = chapter.chapterId.toInt(),
                                                verseId = id + 1
                                            )
                                        )
                                    }
                                }
                            }),
                        shape = RoundedCornerShape(corner = CornerSize(35.dp)),
                        backgroundColor = Color.White,
                        contentColor = Color.Black,
                        elevation = 5.dp
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = null
                        )
                    }
                }

                Text(
                    text = chapter.chapterContent[id].verseName,
                    modifier = Modifier.align(alignment = Alignment.CenterVertically),
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
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = null
                        )
                    }
                } else {
                    Card(
                        modifier = Modifier
                            .size(35.dp)
                            .clickable(onClick = {
                                id += 1
                                if (isMainScreen == true) {
                                    if (currentVerseList.isEmpty()) {
                                        currentVerseViewModel.deleteAllCurrentVerses()
                                        currentVerseViewModel.insertCurrentVerse(
                                            CurrentVerse(
                                                chapterId = chapter.chapterId.toInt(),
                                                verseId = id + 1
                                            )
                                        )
                                    }
                                }
                            }),
                        shape = RoundedCornerShape(corner = CornerSize(35.dp)),
                        backgroundColor = Color.White,
                        contentColor = Color.Black,
                        elevation = 5.dp
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
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
                        contentDescription = "Favourites Icon",
                        tint = Color(0xFFFD950E)
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

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(state = ScrollState(0)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = chapter.chapterContent[id].verse,
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W600,
                    lineHeight = 25.sp,
                    style = MaterialTheme.typography.caption,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = chapter.chapterContent[id].verseMeaning,
                    color = Color.Black,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.W400,
                    lineHeight = 20.sp,
                    style = MaterialTheme.typography.caption,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}