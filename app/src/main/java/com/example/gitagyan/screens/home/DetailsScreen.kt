package com.example.gitagyan.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
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
import com.example.gitagyan.data.content.Chapter
import com.example.gitagyan.model.Languages
import com.example.gitagyan.data.content.english.getEnglishChapters
import com.example.gitagyan.data.content.hindi.getHindiChapters
import com.example.gitagyan.navigation.AppScreens
import com.example.gitagyan.screens.components.topbar.TopBottomBar


@Composable
fun DetailsScreen(navController: NavController, chapterId: String?){
    val chapters = if (Languages.selectedLanguage == "English") getEnglishChapters() else getHindiChapters()
    TopBottomBar(navController = navController, backgroundColor = Color(0xFFFD950E)){
        if (chapterId != null) {
            Details(chapter = chapters[chapterId.toInt()-1]){ chapterId, verseId ->
                navController.navigate(route = AppScreens.VerseScreen.name + "/${chapterId.toInt()-1}" + "/$verseId" + "/${true}")
            }
        }
    }
}

@Composable
fun Details(chapter: Chapter, onItemClick: (String, String) -> Unit){
    Column(modifier = Modifier
        .padding(15.dp)
        .fillMaxSize()
        .background(color = Color.White, shape = RoundedCornerShape(corner = CornerSize(40.dp))),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.krishna_arjuna),
                contentDescription = "Main Image",
                modifier = Modifier
                    .padding(top = 50.dp, start = 50.dp, end = 50.dp)
                    .aspectRatio(640.dp/640.dp),
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
            Text(
                text = chapter.chapterName,
                color = Color(0xFFFD950E),
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                style = MaterialTheme.typography.caption,
                textAlign = TextAlign.Center
            )
            Text(buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color(0xFFFD950E),
                    fontSize = 15.sp)){
                    append(chapter.totalVerses)
                }
            }, modifier = Modifier.padding(5.dp))

            Card(modifier = Modifier
                .padding(5.dp)
                .clickable {
                    onItemClick(chapter.chapterId, "0")
                },
                shape = RoundedCornerShape(corner = CornerSize(15.dp)),
                backgroundColor = Color(0xFFFD950E),
                contentColor = Color.White) {

                val readingLanguage = if (Languages.selectedLanguage == "English") "Start Reading" else "पढ़ना शुरू करें"

                Text(text = readingLanguage,
                    modifier = Modifier.padding(10.dp),
                    fontWeight = FontWeight.SemiBold,
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

