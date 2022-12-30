package com.example.gitagyan.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gitagyan.data.Chapter
import com.example.gitagyan.data.getChapters
import com.example.gitagyan.screens.components.topbar.TopBottomBar

@Composable
fun VerseScreen(navController: NavController, id : String?) {
    val chapters = getChapters()
    TopBottomBar(navController = navController)
    Box(modifier = Modifier.padding(top = 60.dp, bottom = 60.dp)) {
        for (chapter in chapters) {
            if (id == chapter.chapter_id) {
                Verses(chapter = chapter)
            }
        }
    }
}

@Composable
fun Verses(chapter: Chapter){
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
                Column(modifier = Modifier.padding(10.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    Text(
                        text = chapter.chapter_name,
                        modifier = Modifier.padding(top = 10.dp),
                        style = MaterialTheme.typography.subtitle1,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.padding(10.dp))

                    Text(
                        text = chapter.chapter_content[0].verse_name,
                        color = Color(0xFFFD950E),
                        fontSize = 15.sp,
                        style = MaterialTheme.typography.caption
                    )

                    Spacer(modifier = Modifier.padding(10.dp))

                    Text(
                        text = chapter.chapter_content[0].verse,
                        style = MaterialTheme.typography.subtitle1,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = chapter.chapter_content[0].verse_meaning,
                        style = MaterialTheme.typography.subtitle1,
                        textAlign = TextAlign.Center
                    )

                }
            }
        }
    }
}