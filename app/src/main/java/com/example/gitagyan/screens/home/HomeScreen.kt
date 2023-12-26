package com.example.gitagyan.screens.home

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gitagyan.R
import com.example.gitagyan.data.content.Chapter
import com.example.gitagyan.model.Languages
import com.example.gitagyan.data.content.english.getEnglishChapters
import com.example.gitagyan.data.content.hindi.getHindiChapters
import com.example.gitagyan.navigation.AppScreens
import com.example.gitagyan.screens.components.topbar.TopBottomBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController){
    TopBottomBar(navController = navController, isMainScreen = true, backgroundColor = Color.White){
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(
    navController: NavController,
    chapterList: List<Chapter> = if (Languages.selectedLanguage == "English") getEnglishChapters() else getHindiChapters(),
    currentVerseViewModel: CurrentVerseViewModel = hiltViewModel()
){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(3.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        val currentVerse = currentVerseViewModel.currentVerseList.collectAsState().value
        if(currentVerse.isNotEmpty()){
            Card(modifier = Modifier
                .padding(3.dp)
                .fillMaxWidth()
                .clickable(
                    onClick = {
                        navController.navigate(AppScreens.VerseScreen.name + "/${currentVerse[0].chapterId - 1}" + "/${currentVerse[0].verseId - 1}" + "/${true}")
                    }
                ),
                shape = RoundedCornerShape(corner = CornerSize(20.dp)),
                backgroundColor = Color(0xFFFD950E),
                contentColor = Color.Black,
                elevation = 5.dp) {
                Row{
                    Column(
                        modifier = Modifier.padding(15.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Image(painter = painterResource(id = R.drawable.krishna_arjuna),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(100.dp)
                                .clip(RoundedCornerShape(20.dp))
                            )
                    }
                    Column(
                        modifier = Modifier.padding(15.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = if (Languages.selectedLanguage == "English") "You were reading..." else "आप पढ़ रहे थे...",
                            color = Color(0xFFFFFFFF),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 20.sp,
                            style = MaterialTheme.typography.caption,
                            textAlign = TextAlign.Center
                        )

                        Text(
                            text = chapterList[currentVerse[0].chapterId - 1].chapter,
                            color = Color(0xFFFFFFFF),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                            style = MaterialTheme.typography.caption
                        )
                        Text(
                            text = chapterList[currentVerse[0].chapterId - 1].chapterContent[currentVerse[0].verseId - 1].verseName,
                            color = Color(0xFFFFFFFF),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.W400,
                            style = MaterialTheme.typography.caption
                        )
                    }
                }
            }
        }
        LazyColumn{
            items(items = chapterList){
                ChapterRow(chapter = it){ chapterId ->
                    navController.navigate(route = AppScreens.DetailsScreen.name + "/$chapterId")
                }
            }
        }
    }
}

@Composable
fun ChapterRow(
    chapter : Chapter,
    onItemClick: (String) -> Unit = {}){

    var expanded by remember{
        mutableStateOf(false)
    }

    Card(modifier = Modifier
        .padding(3.dp)
        .fillMaxWidth()
        .clickable {
            onItemClick(chapter.chapterId)
        },
        shape = RoundedCornerShape(corner = CornerSize(20.dp)),
        backgroundColor = Color(0xFFFD950E),
        contentColor = Color.Black,
        elevation = 5.dp) {
        Column(modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = chapter.chapter,
                color = Color(0xFFFFFFFF),
                fontSize = 15.sp,
                style = MaterialTheme.typography.caption
            )
            Text(text = chapter.chapterName,
                color = Color(0xFFFFFFFF),
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                style = MaterialTheme.typography.caption,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                maxLines = if(expanded) 3 else 1
            )

            AnimatedVisibility(visible = expanded) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color.White,
                            fontSize = 15.sp)){
                            append(chapter.totalVerses)
                        }
                    },
                        modifier = Modifier.padding(5.dp),
                        textAlign = TextAlign.Center)

                    Divider(modifier = Modifier.padding(5.dp), color = Color.White)

                    Text(text = chapter.description,
                        modifier = Modifier.padding(5.dp),
                        color = Color.White,
                        fontSize = 15.sp,
                        style = MaterialTheme.typography.caption,
                        textAlign = TextAlign.Justify)
                }
            }
            Icon(
                imageVector = if (expanded) Icons.Filled.KeyboardArrowUp
                else Icons.Filled.KeyboardArrowDown,
                contentDescription = "Down Arrow",
                modifier = Modifier
                    .size(25.dp)
                    .clickable {
                        expanded = !expanded
                    },
                tint = Color.White
            )
        }
    }
}
