package com.example.gitagyan.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
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
import com.alexstyl.swipeablecard.Direction
import com.alexstyl.swipeablecard.ExperimentalSwipeableCardApi
import com.alexstyl.swipeablecard.rememberSwipeableCardState
import com.alexstyl.swipeablecard.swipableCard
import com.example.gitagyan.R
import com.example.gitagyan.data.Chapter
import com.example.gitagyan.data.english.getEnglishChapters
import com.example.gitagyan.screens.components.topbar.TopBottomBar

@Composable
fun VerseScreen(navController: NavController, chapter_id: String?, verse_id: String?) {
    val chapters = getEnglishChapters()
    TopBottomBar(navController = navController)
    Box(modifier = Modifier.padding(top = 60.dp, bottom = 60.dp)) {
        for (chapter in chapters) {
            if (chapter_id == chapter.chapter_id) {
                if (verse_id != null) {
                    Verses(
                        chapter = chapter,
                        verseId = verse_id
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalSwipeableCardApi::class)
@Composable
fun Verses(chapter: Chapter, verseId: String){
    chapter.chapter_id
    var id by remember {
        mutableStateOf(verseId.toInt())
    }
    Surface(modifier = Modifier.fillMaxSize(),
        color = Color(0xFFFD950E)) {
        rememberSwipeableCardState()
        val state = rememberSwipeableCardState()
        Surface(modifier = Modifier
            .padding(start = 15.dp, top = 15.dp, end = 15.dp, bottom = 15.dp)
            .fillMaxSize()
            .swipableCard(
                state = state,
                onSwiped = { direction ->
                    if(direction == Direction.Left){
                        if (id == chapter.total_verses.toInt()-1){
                            println("The swiping was cancelled")
                        }
                        else{
                            id += 1
                        }
                    }
                    else if (direction == Direction.Right){
                        if (id == 0){
                            println("The swiping was cancelled")
                        }
                        else{
                            id -= 1
                        }
                    }
                },
                onSwipeCancel = {
                    println("The swiping was cancelled")
                }
            ),
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

                    Text(
                        text = chapter.chapter_content[id].verse_name,
                        modifier = Modifier.padding(start = 90.dp, end = 90.dp),
                        color = Color(0xFFFD950E),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp,
                        style = MaterialTheme.typography.caption
                    )

                    Spacer(modifier = Modifier.padding(7.dp))

                    Column(modifier = Modifier
                        .verticalScroll(state = ScrollState(0)),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = chapter.chapter_content[id].verse,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.W600,
                            style = MaterialTheme.typography.caption,
                            textAlign = TextAlign.Center
                        )

                        Text(
                            text = chapter.chapter_content[id].verse_meaning,
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