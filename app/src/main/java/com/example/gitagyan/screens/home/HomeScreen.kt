package com.example.gitagyan.screens.home

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gitagyan.screens.components.topbar.TopAppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController){
    TopAppBar(navController = navController)
    Box(modifier = Modifier.padding(top = 50.dp, bottom = 60.dp)) {
        MainContent()
    }
}

@Composable
fun MainContent(
    chapterList: List<String> = listOf(
        "Chapter 1", "Chapter 2", "Chapter 3", "Chapter 4", "Chapter 5"
    )){
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn{
            items(items = chapterList){
                ChapterRow(chapter = it){
//                    Log.d("TAG", "MainContent: $movie")
                }
            }
        }
    }
}

@Composable
fun ChapterRow(chapter : String,
             onItemClick: (String) -> Unit = {}){

    var expanded by remember{
        mutableStateOf(false)
    }

    Card(modifier = Modifier
        .padding(3.dp)
        .fillMaxWidth()
        .clickable {
            onItemClick(chapter)
        },
        shape = RoundedCornerShape(corner = CornerSize(17.dp)),
        backgroundColor = Color(0xFFFD950E),
        contentColor = Color.Black,
        elevation = 7.dp) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Column(modifier = Modifier.padding(5.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = chapter,
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = "Genre",
                    style = MaterialTheme.typography.caption
                )

                AnimatedVisibility(visible = expanded) {
                    Column {
                        Text(buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.Black,
                                fontSize = 13.sp)){
                                append("Total Verses : ")
                            }
                            withStyle(style = SpanStyle(color = Color.Black,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Light
                            )){
                                append(chapter)
                            }
                        }, modifier = Modifier.padding(6.dp))

                        Divider(modifier = Modifier.padding(6.dp))
                        Text(text = "Director",
                            modifier = Modifier.padding(start = 5.dp),
                            style = MaterialTheme.typography.subtitle1)
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
                    tint = Color.DarkGray
                )

            }

        }
    }
}

@Preview
@Composable
fun Prev1(){
    MainContent()
}