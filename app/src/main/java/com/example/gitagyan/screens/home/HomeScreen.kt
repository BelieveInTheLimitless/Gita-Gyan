package com.example.gitagyan.screens.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.gitagyan.R
import com.example.gitagyan.data.content.Chapter
import com.example.gitagyan.model.Languages
import com.example.gitagyan.data.content.english.getEnglishChapters
import com.example.gitagyan.data.content.hindi.getHindiChapters
import com.example.gitagyan.screens.AppScreens
import com.example.gitagyan.screens.components.TopBar
import com.example.gitagyan.screens.favourite.FavouriteViewModel

@Composable
fun HomeNavHost(favouriteViewModel: FavouriteViewModel = hiltViewModel()) {

    val homeNavController = rememberNavController()

    val isMainScreen = remember {
        mutableStateOf(true)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(isHomeScreen = isMainScreen.value) {
                homeNavController.popBackStack()
            }
        },
        containerColor = if(isMainScreen.value) Color.White else Color(0xFFFD950E)
    ) {
        NavHost(navController = homeNavController,
            startDestination = "homeContent",
            modifier = Modifier.padding(it)
        ) {
            composable("homeContent") {
                isMainScreen.value = true
                MainContent(navController = homeNavController)
            }

            composable(
                AppScreens.DetailsScreen.name+"/{chapter_id}",
                arguments = listOf(navArgument(name = "chapter_id") {type = NavType.StringType})
            ){ backStackEntry ->
                isMainScreen.value = false
                DetailsScreen(navController = homeNavController, chapterId = backStackEntry.arguments?.getString("chapter_id"))
            }

            composable(
                AppScreens.VerseScreen.name+"/{chapter_id}"+"/{verse_id}"+"/{isMainScreen}",
                arguments = listOf(
                    navArgument(name = "chapter_id") {type = NavType.StringType},
                    navArgument(name = "verse_id") { type = NavType.StringType},
                    navArgument(name = "isMainScreen") { type = NavType.BoolType}
                )
            ){ backStackEntry ->
                isMainScreen.value = false
                VerseScreen(
                    favouriteViewModel = favouriteViewModel,
                    chapterId = backStackEntry.arguments?.getString("chapter_id"),
                    verseId = backStackEntry.arguments?.getString("verse_id"),
                    isMainScreen = backStackEntry.arguments?.getBoolean("isMainScreen")
                )
            }
        }
    }
}


@Composable
fun MainContent(
    navController: NavController,
    chapterList: List<Chapter> = if (Languages.selectedLanguage == "English") getEnglishChapters() else getHindiChapters(),
    currentVerseViewModel: CurrentVerseViewModel = hiltViewModel()
){
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.White)
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
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFD950E), contentColor = Color.Black),
                elevation = CardDefaults.cardElevation(5.dp)) {
                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically){
                    Column(
                        modifier = Modifier
                            .weight(0.3F)
                            .padding(15.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Image(painter = painterResource(id = R.drawable.main_icon),
                            contentDescription = "Home Screen Image",
                            modifier = Modifier
                                .aspectRatio(640.dp / 640.dp)
                                .clip(RoundedCornerShape(20.dp)),
                            alignment = Alignment.CenterStart
                            )
                    }
                    Column(
                        modifier = Modifier
                            .weight(0.7F)
                            .padding(15.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = if (Languages.selectedLanguage == "English") "You were reading..." else "आप पढ़ रहे थे...",
                            color = Color(0xFFFFFFFF),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 20.sp,
                            style = MaterialTheme.typography.titleSmall
                        )

                        Text(
                            text = chapterList[currentVerse[0].chapterId - 1].chapter,
                            color = Color(0xFFFFFFFF),
                            fontSize = 18.sp,
                            style = MaterialTheme.typography.titleSmall
                        )
                        Text(
                            text = chapterList[currentVerse[0].chapterId - 1].chapterContent[currentVerse[0].verseId - 1].verseName,
                            color = Color(0xFFFFFFFF),
                            fontSize = 17.sp,
                            style = MaterialTheme.typography.titleSmall
                        )
                    }
                }
            }
        }
        LazyColumn(modifier = Modifier.fillMaxWidth()){
            items(items = chapterList, key = {chapter -> chapter.chapterId}){
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
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFD950E), contentColor = Color.Black),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = chapter.chapter,
                modifier = Modifier.padding(5.dp),
                color = Color(0xFFFFFFFF),
                fontSize = 17.sp,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium
            )
            Text(text = chapter.chapterName,
                color = Color(0xFFFFFFFF),
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                lineHeight = 25.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = if(expanded) 5 else 1,
                style = MaterialTheme.typography.titleMedium
            )

            AnimatedVisibility(visible = expanded) {
                Column(modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color.White,
                            fontSize = 15.sp, fontWeight = FontWeight.SemiBold)){
                            append(chapter.totalVerses)
                        }
                    },
                        modifier = Modifier.padding(5.dp),
                        textAlign = TextAlign.Center)

                    Divider(modifier = Modifier.padding(5.dp), color = Color.White)

                    Text(text = chapter.description,
                        modifier = Modifier.padding(5.dp),
                        color = Color.White,
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        style = MaterialTheme.typography.displaySmall,
                        textAlign = TextAlign.Justify)


                }
            }
            Icon(
                imageVector = if (expanded) Icons.Filled.KeyboardArrowUp
                else Icons.Filled.KeyboardArrowDown,
                contentDescription = "Down Arrow",
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        expanded = !expanded
                    },
                tint = Color.White
            )
        }
    }
}
