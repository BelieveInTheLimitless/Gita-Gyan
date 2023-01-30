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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gitagyan.R
import com.example.gitagyan.data.english.getEnglishChapters
import com.example.gitagyan.screens.components.topbar.TopBottomBar

@Composable
fun SearchScreen(navController: NavController){
    TopBottomBar(navController = navController)
    Box(modifier = Modifier.padding(top = 60.dp, bottom = 60.dp)) {
        Search()
    }
}

@Composable
fun Search(onValChange: (String) -> Unit = {}){
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

                        var chapterId by remember {
                            mutableStateOf("")
                        }

                        val context = LocalContext.current.applicationContext

                        Column(
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {

                            OutlinedTextField(
                                value = chapterId,
                                onValueChange = { newText ->
                                    chapterId = newText
                                },
                                label = { Text(text = "Chapter number") },
                                placeholder = { Text(text = "Enter Chapter number") },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number,
                                    imeAction = ImeAction.Search
                                ),
                                keyboardActions = KeyboardActions(
                                    onSearch = {
                                        for (chapter in chapters){
                                            if(chapterId == chapter.chapter_id) {
                                                Toast.makeText(
                                                    context,
                                                    "Selected chapter is $chapter",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            }
                                        }
                                        if (chapterId < 1.toString() || chapterId > 18.toString()){
                                                Toast.makeText(context, "Enter valid chapter number!", Toast.LENGTH_SHORT).show()
                                        }
                                    }
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}



