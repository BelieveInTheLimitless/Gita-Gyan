package com.example.gitagyan.screens.save.presentation.verses.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.gitagyan.database.domain.model.Verse


@Composable
fun VerseItem(
    modifier: Modifier = Modifier,
    verse: Verse,
    onDeleteClick: () -> Unit
){
    Card(modifier = Modifier
        .padding(3.dp)
        .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(20.dp)),
        backgroundColor = Color(0xFFFD950E),
        contentColor = Color.Black,
        elevation = 7.dp) {
        Row(modifier = Modifier
            .fillMaxSize()) {
            Column(
                modifier = Modifier
                    .padding(start = 16.dp, end = 32.dp)
            ) {
                Text(
                    text = "Chapter " + verse.chapterId,
                    style = MaterialTheme.typography.h6,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Verse " + verse.verseId,
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.onSurface
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            IconButton(onClick = onDeleteClick) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete Verse"
                )
            }
        }
    }
}
