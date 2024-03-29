package com.example.gitagyan.screens.search

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
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
import com.example.gitagyan.screens.AppScreens
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
            modifier = Modifier.padding(it)
        ) {
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
                painter = painterResource(id = R.drawable.main_icon),
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

            val localFocusManager = LocalFocusManager.current

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
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium,
                    style = MaterialTheme.typography.titleLarge
                )

                InputField(valueState = chapterId,
                    labelId = enterChapterLanguage,
                    enabled = true,
                    isSingleLine = true,
                    onAction = KeyboardActions {
                        if (!chapterValidState) return@KeyboardActions
                        onValChange(chapterId.value.trim())
                        localFocusManager.moveFocus(focusDirection = FocusDirection.Down)
                    }
                )

                if (chapterId.value.isNotEmpty()) {
                    if (chapterId.value.isDigitsOnly() && chapterId.value.toInt() > 0 && (chapterId.value.toInt() <= 18)) {
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
                    if (verseId.value.isDigitsOnly() && (verseId.value.toInt() > 0) && (verseId.value.toInt() <= chapters[chapterId.value.toInt() - 1].chapterContent.size)) {
                        Card(modifier = Modifier
                            .padding(5.dp)
                            .clickable(
                                onClick = {
                                    navController.navigate(route = AppScreens.VerseScreen.name + "/${chapterId.value.toInt() - 1}" + "/${verseId.value.toInt() - 1}" + "/${false}")
                                },
                                onClickLabel = "Search"
                            ),
                            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFFD950E), contentColor = Color.White))
                        {
                            Text(
                                text = proceedLanguage,
                                modifier = Modifier.padding(10.dp),
                                color = Color.White,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.titleMedium
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
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            disabledTextColor = Color.Black,
            focusedBorderColor = Color(0xFFFD950E),
            unfocusedBorderColor = Color(0xFFFD950E),
            focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.Black,
            focusedPlaceholderColor = Color.Black,
            disabledPlaceholderColor = Color.Black,
        )
    )
}