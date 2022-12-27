package com.example.gitagyan.screens.components.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gitagyan.data.Chapter

@Composable
fun Details(chapter: Chapter){
    Column() {
        Surface(modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(corner = CornerSize(10.dp)),
            color = Color.White) {
            Text(text = chapter.chapter_id,
                color = Color.Black,
                modifier = Modifier.padding(top = 275.dp),
                fontSize = 25.sp,
                textAlign = TextAlign.Center)
        }
    }
}