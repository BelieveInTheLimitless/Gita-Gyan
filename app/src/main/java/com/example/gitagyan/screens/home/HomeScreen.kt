package com.example.gitagyan.screens.home

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
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
import com.example.gitagyan.navigation.AppScreens
import com.example.gitagyan.screens.components.TopBar
import com.example.gitagyan.screens.favourite.FavouriteViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeNavHost(favouriteViewModel: FavouriteViewModel = hiltViewModel()) {

    val homeNavController = rememberNavController()

    val isMainScreen = remember {
        mutableStateOf(true)
    }

    Scaffold(
        topBar = {
            TopBar(isHomeScreen = isMainScreen.value) {
                homeNavController.popBackStack()
            }
        },
        containerColor = if(isMainScreen.value) Color.White else Color(0xFFFD950E)
    ) {
        NavHost(navController = homeNavController,
            startDestination = "homeContent",
            modifier = Modifier.padding(it),
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(350)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(350)
                )
            },
            popEnterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(350)
                )
            },
            popExitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(350)
                )
            }) {
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
        .fillMaxSize()
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
                backgroundColor = Color(0xFFFD950E),
                contentColor = Color.Black,
                elevation = 5.dp) {
                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically){
                    Column(
                        modifier = Modifier
                            .weight(0.3F)
                            .padding(15.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Image(painter = painterResource(id = R.drawable.krishna_arjuna),
                            contentDescription = "Home Screen Image ",
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
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                maxLines = if(expanded) 5 else 1,
                style = MaterialTheme.typography.caption
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
