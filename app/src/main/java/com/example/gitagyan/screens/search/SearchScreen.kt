package com.example.gitagyan.screens.search

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.navigation.NavController
import com.example.gitagyan.R
import com.example.gitagyan.model.Languages
import com.example.gitagyan.data.content.english.getEnglishChapters
import com.example.gitagyan.data.content.hindi.getHindiChapters
import com.example.gitagyan.navigation.AppScreens
import com.example.gitagyan.screens.components.topbar.TopBottomBar

@Composable
fun SearchScreen(navController: NavController){
    TopBottomBar(navController = navController)
    Box(modifier = Modifier.padding(top = 60.dp, bottom = 60.dp)) {
        Search(navController = navController)
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Search(navController : NavController, onValChange: (String) -> Unit = {}){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        color = Color(0xFFFD950E)
    ) {
        Surface(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            shape = RoundedCornerShape(corner = CornerSize(40.dp)),
            color = Color.White,
            contentColor = Color.Black
        ) {
            Row(
                Modifier.padding(top = 45.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Box {
                    Column(
                        modifier = Modifier.padding(10.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.krishna_arjuna),
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds
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
                                .padding(top = 20.dp)
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
                                modifier = Modifier.padding(10.dp),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
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
                                            navController.navigate(route = AppScreens.VerseScreen.name + "/${chapterId.value.toInt() - 1}" + "/${verseId.value.toInt() - 1}")
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
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
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