package com.example.gitagyan.screens.home

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gitagyan.R
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
            .padding(start = 15.dp, top = 15.dp, end = 15.dp, bottom = 15.dp)
            .width(1000.dp)
            .height(500.dp),
            shape = RoundedCornerShape(corner = CornerSize(40.dp)),
            color = Color.White,
            contentColor = Color.Black) {
            Row(Modifier.padding(top = 45.dp, bottom = 45.dp),
                horizontalArrangement = Arrangement.Center) {
                Column(modifier = Modifier.padding(10.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    Image(painter = painterResource(id = R.drawable.krishna_arjuna),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds)

                    Spacer(modifier = Modifier.padding(5.dp))

                    Text(
                        text = chapter.chapter_name,
                        modifier = Modifier.padding(top = 10.dp),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.W600,
                        style = MaterialTheme.typography.h4,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.padding(7.dp))

                    Row(horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically) {
                        Card(modifier = Modifier
                            .width(50.dp)
                            .height(50.dp)
                            .clickable {
                            },
                            shape = RoundedCornerShape(corner = CornerSize(30.dp)),
                            backgroundColor = Color(0xFFFD950E),
                            contentColor = Color.White) {
                            Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = null)
                        }

                        Text(
                            text = chapter.chapter_content[0].verse_name,
                            modifier = Modifier.padding(start = 90.dp, end = 90.dp),
                            color = Color(0xFFFD950E),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 20.sp,
                            style = MaterialTheme.typography.caption
                        )
                        Card(modifier = Modifier
                            .width(50.dp)
                            .height(50.dp)
                            .clickable {
                            },
                            shape = RoundedCornerShape(corner = CornerSize(30.dp)),
                            backgroundColor = Color(0xFFFD950E),
                            contentColor = Color.White) {
                            Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null)
                        }
                    }

                    Spacer(modifier = Modifier.padding(7.dp))

                    Column(modifier = Modifier
                        .verticalScroll(state = ScrollState(0)),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = chapter.chapter_content[0].verse,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.W600,
                            style = MaterialTheme.typography.caption,
                            textAlign = TextAlign.Center
                        )

                        Text(
                            text = chapter.chapter_content[0].verse_meaning,
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