package com.example.gitagyan.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
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
import com.example.gitagyan.data.Chapter
import com.example.gitagyan.data.getChapters
import com.example.gitagyan.navigation.AppScreens
import com.example.gitagyan.screens.components.topbar.TopBottomBar

@Composable
fun DetailsScreen(navController: NavController, id: String?){
    val chapters = getChapters()
    TopBottomBar(navController = navController)
    Box(modifier = Modifier.padding(top = 60.dp, bottom = 60.dp)) {
        for (chapter in chapters){
            if(id == chapter.chapter_id){
                Details(chapter = chapter){ id ->
                    navController.navigate(route = AppScreens.VerseScreen.name + "/$id")
                }
            }
        }
    }
}

@Composable
fun Details(chapter: Chapter, onItemClick: (String) -> Unit = {}){
    Surface(modifier = Modifier.fillMaxSize(),
        color = Color(0xFFFD950E)
    ) {
        Surface(modifier = Modifier
            .padding(start = 15.dp, top = 20.dp, end = 15.dp, bottom = 20.dp)
            .width(1000.dp)
            .height(500.dp),
            shape = RoundedCornerShape(corner = CornerSize(40.dp)),
            color = Color.White,
            contentColor = Color.Black) {
            Row(
                horizontalArrangement = Arrangement.Center) {
                Column(modifier = Modifier.padding(5.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Chapter " + chapter.chapter_id,
                        color = Color(0xFFFD950E),
                        fontSize = 15.sp,
                        style = MaterialTheme.typography.caption
                    )
                    Text(
                        text = chapter.chapter_name,
                        color = Color(0xFFFD950E),
                        fontSize = 20.sp,
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.W600
                    )

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Black,
                                    fontSize = 13.sp
                                )
                            ) {
                                append("Total Verses : " + chapter.total_verses)
                            }
                        }, modifier = Modifier.padding(6.dp))

                        Divider(modifier = Modifier.padding(6.dp))
                        Text(
                            text = chapter.description,
                            modifier = Modifier.padding(start = 5.dp),
                            style = MaterialTheme.typography.subtitle1
                        )
                        Divider(modifier = Modifier.padding(10.dp))
                        Card(modifier = Modifier
                            .padding(3.dp)
                            .width(100.dp)
                            .height(50.dp)
                            .clickable {
                                onItemClick(chapter.chapter_id)
                            },
                            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
                            backgroundColor = Color(0xFFFD950E),
                            contentColor = Color.White) {
                            Text(text = "Start Reading",
                                modifier = Modifier.padding(3.dp),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}

