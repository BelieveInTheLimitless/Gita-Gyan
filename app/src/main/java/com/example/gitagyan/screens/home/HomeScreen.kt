package com.example.gitagyan.screens.home

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gitagyan.data.english.Chapter
import com.example.gitagyan.data.english.getEnglishChapters
import com.example.gitagyan.navigation.AppScreens
import com.example.gitagyan.screens.components.topbar.TopBottomBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController){
    TopBottomBar(navController = navController)
    Box(modifier = Modifier.padding(top = 45.dp, bottom = 45.dp)) {
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(
    navController: NavController,
    chapterList: List<Chapter> = getEnglishChapters()
){
    Column(modifier = Modifier.padding(10.dp)) {
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
        .fillMaxWidth().
        clickable {
            onItemClick(chapter.chapterId)
        },
        shape = RoundedCornerShape(corner = CornerSize(20.dp)),
        backgroundColor = Color(0xFFFD950E),
        contentColor = Color.Black,
        elevation = 7.dp) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Column(modifier = Modifier.padding(5.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Chapter "+chapter.chapterId,
                    color = Color(0xFFFFFFFF),
                    fontSize = 15.sp,
                    style = MaterialTheme.typography.caption
                )
                Text(text = chapter.chapterName,
                    color = Color(0xFFFFFFFF),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.caption
                )

                AnimatedVisibility(visible = expanded) {
                    Column {
                        Text(buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.White,
                                fontSize = 15.sp)){
                                append("Total Verses : "+chapter.totalVerses)
                            }
                        }, modifier = Modifier.padding(6.dp))

                        Divider(modifier = Modifier.padding(6.dp))

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
}
