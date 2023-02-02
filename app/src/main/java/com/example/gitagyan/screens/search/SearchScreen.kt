package com.example.gitagyan.screens.search

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
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
import com.example.gitagyan.data.english.getEnglishChapters
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
    Surface(modifier = Modifier.fillMaxSize(),
        color = Color(0xFFFD950E)) {
        Surface(modifier = Modifier
            .padding(start = 15.dp, top = 15.dp, end = 15.dp, bottom = 15.dp)
            .width(1000.dp)
            .height(500.dp),
            shape = RoundedCornerShape(corner = CornerSize(40.dp)),
            color = Color.White,
            contentColor = Color.Black) {
            Row(Modifier.padding(top = 45.dp),
                horizontalArrangement = Arrangement.Center) {
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

                        val chapters = getEnglishChapters()

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

                            Text(text = "Search",
                                modifier = Modifier.padding(10.dp),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Serif,
                                style = MaterialTheme.typography.caption
                            )

                            InputField(valueState = chapterId,
                                labelId = "Enter Chapter Number",
                                enabled = true,
                                isSingleLine = true,
                                onAction = KeyboardActions {
                                    if (!chapterValidState) return@KeyboardActions
                                    onValChange(chapterId.value.trim())
                                    keyboardController?.hide()
                                }
                            )

                            if(chapterId.value.isNotEmpty()){
                                if(chapterId.value.toInt() > 0 && (chapterId.value.toInt() <= 18)){
                                    InputField(valueState = verseId,
                                        labelId = "Enter Verse Number",
                                        enabled = true,
                                        isSingleLine = true,
                                        onAction = KeyboardActions {
                                            if (!verseValidState) return@KeyboardActions
                                            onValChange(verseId.value.trim())
                                            keyboardController?.hide()
                                        }
                                    )
                                }
                                else{
                                    Toast.makeText(context, "Enter valid chapter number!", Toast.LENGTH_SHORT).show()
                                }
                            }

                            if(verseId.value.isNotEmpty()){
                                if((verseId.value.toInt() > 0) && (verseId.value.toInt() <= chapters[chapterId.value.toInt()-1].total_verses.toInt())){
                                    Button(onClick = {
                                        navController.navigate(route = AppScreens.VerseScreen.name + "/${chapterId.value}" + "/${verseId.value.toInt()-1}") },
                                        modifier = Modifier
                                            .padding(10.dp)
                                            .width(100.dp)
                                            .height(55.dp),
                                        shape = RoundedCornerShape(corner = CornerSize(15.dp)),
                                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFD950E))
                                    ) {
                                        Text(text = "Search",
                                            color = Color.White,
                                            fontSize = 15.sp,
                                            modifier = Modifier.padding(4.dp),
                                            textAlign = TextAlign.Center
                                        )
                                    }
                                }
                                else{
                                    Toast.makeText(context, "Enter valid verse number!", Toast.LENGTH_SHORT).show()
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
        label = { Text(text =  labelId) },
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



