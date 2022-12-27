package com.example.gitagyan.screens.components.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gitagyan.data.Chapter

@Composable
fun Details(chapter: Chapter){
        Surface(modifier = Modifier.fillMaxSize(),
            color = Color.White) {
            Surface(modifier = Modifier
                .padding(10.dp)
                .width(1000.dp),
                shape = RoundedCornerShape(corner = CornerSize(17.dp)),
                color = Color(0xFFFD950E),
                contentColor = Color.Black) {
                Row(
                    horizontalArrangement = Arrangement.Center) {
                    Column(modifier = Modifier.padding(5.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Chapter " + chapter.chapter_id,
                            color = Color(0xFFFFFFFF),
                            fontSize = 15.sp,
                            style = MaterialTheme.typography.caption
                        )
                        Text(
                            text = chapter.chapter_name,
                            color = Color(0xFFFFFFFF),
                            fontSize = 20.sp,
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.W600
                        )

                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.Black,
                                        fontSize = 13.sp
                                    )
                                ) {
                                    append("Total Verses : " + chapter.total_verses)
                                }
                            }, modifier = Modifier.padding(6.dp))

                            Divider(modifier = Modifier.padding(6.dp))
                            Text(
                                text = chapter.chapter_content[0].verse_meaning,
                                modifier = Modifier.padding(start = 5.dp),
                                style = MaterialTheme.typography.subtitle1
                            )
                            Divider(modifier = Modifier.padding(10.dp))
                            Card(modifier = Modifier
                                .padding(3.dp)
                                .width(100.dp)
                                .height(50.dp)
                                .clickable {
                                },
                                shape = RoundedCornerShape(corner = CornerSize(10.dp)),
                                backgroundColor = Color(0xFFFFFFFF),
                                contentColor = Color.Black) {
                                Text(text = "Start Reading",
                                    modifier = Modifier.padding(3.dp),
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }
            }
        }
}