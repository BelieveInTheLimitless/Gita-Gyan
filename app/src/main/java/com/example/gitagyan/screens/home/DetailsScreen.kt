package com.example.gitagyan.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gitagyan.R
import com.example.gitagyan.data.english.Chapter
import com.example.gitagyan.data.english.getEnglishChapters
import com.example.gitagyan.navigation.AppScreens
import com.example.gitagyan.screens.components.topbar.TopBottomBar


@Composable
fun DetailsScreen(navController: NavController, chapterId: String?){
    val chapters = getEnglishChapters()
    TopBottomBar(navController = navController)
    Box(modifier = Modifier.padding(top = 60.dp, bottom = 60.dp)) {
        if (chapterId != null) {
            Details(chapter = chapters[chapterId.toInt()-1]){ chapterId, verseId ->
                navController.navigate(route = AppScreens.VerseScreen.name + "/${chapterId.toInt()-1}" + "/$verseId")
            }
        }
    }
}

@Composable
fun Details(chapter: Chapter, onItemClick: (String, String) -> Unit){
    Surface(modifier = Modifier.fillMaxSize(),
        color = Color(0xFFFD950E)) {
        Surface(modifier = Modifier
            .padding(15.dp)
            .fillMaxSize(),
            shape = RoundedCornerShape(corner = CornerSize(40.dp)),
            color = Color.White,
            contentColor = Color.Black) {
            Row(Modifier.padding(top = 45.dp),
                horizontalArrangement = Arrangement.Center) {
                Column(modifier = Modifier.padding(10.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    Image(painter = painterResource(id = R.drawable.krishna_arjuna),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds)

                    Spacer(modifier = Modifier.padding(5.dp))

                    Text(
                        text = "Chapter " + chapter.chapterId,
                        color = Color(0xFFFD950E),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.caption
                    )
                    Text(
                        text = chapter.chapterName,
                        color = Color(0xFFFD950E),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp,
                        style = MaterialTheme.typography.caption
                    )
                    Text(buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color(0xFFFD950E),
                            fontSize = 15.sp)){
                            append("Total Verses : "+chapter.totalVerses)
                        }
                    }, modifier = Modifier.padding(5.dp))

                    Card(modifier = Modifier
                        .padding(2.dp)
                        .width(100.dp)
                        .height(55.dp)
                        .clickable {
                            onItemClick(chapter.chapterId, "0")
                        },
                        shape = RoundedCornerShape(corner = CornerSize(15.dp)),
                        backgroundColor = Color(0xFFFD950E),
                        contentColor = Color.White) {
                        Text(text = "Start Reading",
                            modifier = Modifier.padding(4.dp),
                            textAlign = TextAlign.Center
                        )
                    }

                    Divider(modifier = Modifier.padding(5.dp),
                        color = Color.LightGray)

                    Column(modifier = Modifier
                        .padding(1.dp)
                        .verticalScroll(state = ScrollState(0)),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = chapter.description,
                            modifier = Modifier.padding(5.dp),
                            fontSize = 15.sp,
                            style = MaterialTheme.typography.caption,
                            textAlign = TextAlign.Justify
                        )
                    }
                }
            }
        }
    }
}

