package com.example.gitagyan.screens.search

import android.widget.Toast
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
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
import com.example.gitagyan.model.Languages
import com.example.gitagyan.data.content.english.getEnglishChapters
import com.example.gitagyan.data.content.hindi.getHindiChapters
import com.example.gitagyan.navigation.AppScreens
import com.example.gitagyan.screens.components.TopBar
import com.example.gitagyan.screens.favourite.FavouriteViewModel
import com.example.gitagyan.screens.home.VerseScreen

@Composable
fun SearchNavHost(rootNavController: NavController, favouriteViewModel: FavouriteViewModel = hiltViewModel()) {

    val searchNavController = rememberNavController()

    val isSearchScreen = remember {
        mutableStateOf(true)
    }

    Scaffold(
        topBar = {
            TopBar {
                if (isSearchScreen.value){
                    rootNavController.popBackStack()
                }else{
                    searchNavController.popBackStack()
                }
            }
        },
        containerColor = Color(0xFFFD950E)
    ) {
        NavHost(navController = searchNavController,
            startDestination = "searchContent",
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
            composable("searchContent") {
                isSearchScreen.value = true
                Search(navController = searchNavController)
            }

            composable(
                AppScreens.VerseScreen.name+"/{chapter_id}"+"/{verse_id}"+"/{isMainScreen}",
                arguments = listOf(
                    navArgument(name = "chapter_id") {type = NavType.StringType},
                    navArgument(name = "verse_id") { type = NavType.StringType},
                    navArgument(name = "isMainScreen") { type = NavType.BoolType}
                )
            ){ backStackEntry ->
                isSearchScreen.value = false
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

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Search(navController : NavController, onValChange: (String) -> Unit = {}){
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
                    .aspectRatio(640.dp / 640.dp),
                contentScale = ContentScale.FillWidth
            )

            val chapters =
                if (Languages.selectedLanguage == "English") getEnglishChapters() else getHindiChapters()

            val chapterId = remember {
                mutableStateOf("")
            }

            val chapterValidState = remember(chapterId.value) {
                chapterId.value.trim().isNotEmpty()
            }

            val verseId = remember {
                mutableStateOf("")
            }

            val verseValidState = remember(verseId.value) {
                verseId.value.trim().isNotEmpty()
            }

            val keyboardController = LocalSoftwareKeyboardController.current

            val context = LocalContext.current

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                val searchLanguage = if (Languages.selectedLanguage == "English") "Search" else "खोजे"
                val enterChapterLanguage = if (Languages.selectedLanguage == "English") "Enter Chapter Number" else "अध्याय क्रमांक"
                val enterVerseLanguage = if (Languages.selectedLanguage == "English") "Enter Verse Number" else "श्लोक क्रमांक"
                val proceedLanguage = if (Languages.selectedLanguage == "English") "Proceed" else "आगे बढे"
                val chapterErrorMessage = if (Languages.selectedLanguage == "English") "Enter Valid Chapter Number" else "सही अध्याय का चयन करे!"
                val verseErrorMessage = if (Languages.selectedLanguage == "English") "Enter Valid Verse Number" else "सही श्लोक का चयन करे!"

                Text(
                    text = searchLanguage,
                    modifier = Modifier.padding(top = 10.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily.Serif,
                    style = MaterialTheme.typography.titleMedium
                )

                InputField(valueState = chapterId,
                    labelId = enterChapterLanguage,
                    enabled = true,
                    isSingleLine = true,
                    onAction = KeyboardActions {
                        if (!chapterValidState) return@KeyboardActions
                        onValChange(chapterId.value.trim())
                        keyboardController?.hide()
                    }
                )

                if (chapterId.value.isNotEmpty()) {
                    if (chapterId.value.toInt() > 0 && (chapterId.value.toInt() <= 18)) {
                        InputField(valueState = verseId,
                            labelId = enterVerseLanguage,
                            enabled = true,
                            isSingleLine = true,
                            onAction = KeyboardActions {
                                if (!verseValidState) return@KeyboardActions
                                onValChange(verseId.value.trim())
                                keyboardController?.hide()
                            }
                        )
                    } else {
                        Toast.makeText(
                            context,
                            chapterErrorMessage,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                if (verseId.value.isNotEmpty()) {
                    if ((verseId.value.toInt() > 0) && (verseId.value.toInt() <= chapters[chapterId.value.toInt() - 1].chapterContent.size)) {
                        Button(
                            onClick = {
                                navController.navigate(route = AppScreens.VerseScreen.name + "/${chapterId.value.toInt() - 1}" + "/${verseId.value.toInt() - 1}" + "/${false}")
                            },
                            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(
                                    0xFFFD950E
                                )
                            )
                        ) {
                            Text(
                                text = proceedLanguage,
                                modifier = Modifier.padding(3.dp),
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Center
                            )
                        }
                    } else {
                        Toast.makeText(
                            context,
                            verseErrorMessage,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}

@Composable
fun InputField(
    modifier: Modifier = Modifier,
    valueState: MutableState<String>,
    labelId: String,
    enabled: Boolean,
    isSingleLine: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Number,
    imeAction: ImeAction = ImeAction.Go,
    onAction: KeyboardActions = KeyboardActions.Default
) {
    OutlinedTextField(
        value = valueState.value,
        onValueChange = { valueState.value = it },
        label = { Text(text = labelId) },
        singleLine = isSingleLine,
        textStyle = TextStyle(fontSize = 15.sp, color = Color.Black),
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth(),
        enabled = enabled,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        keyboardActions = onAction,
        shape = RoundedCornerShape(15.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black,
            disabledTextColor = Color.Black,
            unfocusedLabelColor = Color.Black,
            unfocusedBorderColor = Color(0xFFFD950E),
            focusedLabelColor = Color.Black,
            focusedBorderColor = Color(0xFFFD950E),
            placeholderColor = Color.Black,
            disabledPlaceholderColor = Color.Black)
    )
}