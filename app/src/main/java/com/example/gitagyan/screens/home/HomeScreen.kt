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
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gitagyan.data.Chapter
import com.example.gitagyan.data.getChapters
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
fun MainContent(navController: NavController,
    chapterList: List<Chapter> = getChapters()){
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn{
            items(items = chapterList){
                ChapterRow(chapter = it){ chapter ->
                    navController.navigate(route = AppScreens.DetailsScreen.name + "/$chapter")
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
                  onItemClick(chapter.chapter_id)
        },
        shape = RoundedCornerShape(corner = CornerSize(17.dp)),
        backgroundColor = Color(0xFFFD950E),
        contentColor = Color.Black,
        elevation = 7.dp) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Column(modifier = Modifier.padding(5.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Chapter "+chapter.chapter_id,
                    color = Color(0xFFFFFFFF),
                    fontSize = 15.sp,
                    style = MaterialTheme.typography.caption
                )
                Text(text = chapter.chapter_name,
                    color = Color(0xFFFFFFFF),
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.W600
                )

                AnimatedVisibility(visible = expanded) {
                    Column {
                        Text(buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.Black,
                                fontSize = 13.sp)){
                                append("Total Verses : "+chapter.total_verses)
                            }
                        }, modifier = Modifier.padding(6.dp))

                        Divider(modifier = Modifier.padding(6.dp))
                        Text(text = chapter.chapter_content[0].verse_meaning,
                            modifier = Modifier.padding(start = 5.dp),
                            style = MaterialTheme.typography.subtitle1)
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
