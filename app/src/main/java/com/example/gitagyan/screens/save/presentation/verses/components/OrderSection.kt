package com.example.gitagyan.screens.save.presentation.verses.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gitagyan.database.domain.util.OrderType
import com.example.gitagyan.database.domain.util.VerseOrder

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    verseOrder: VerseOrder = VerseOrder.Date(OrderType.Descending),
    onOrderChange: (VerseOrder) -> Unit
){
    Column(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth()) {
            DefaultRadioButton(text = "Chapter",
                selected = verseOrder is VerseOrder.ChapterId,
                onSelect = { onOrderChange(VerseOrder.ChapterId(verseOrder.orderType)) })
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(text = "Verse",
                selected = verseOrder is VerseOrder.VerseId,
                onSelect = { onOrderChange(VerseOrder.VerseId(verseOrder.orderType)) })
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(text = "Date",
                selected = verseOrder is VerseOrder.Date,
                onSelect = { onOrderChange(VerseOrder.Date(verseOrder.orderType)) })
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            DefaultRadioButton(text = "Ascending",
                selected = verseOrder.orderType is OrderType.Ascending,
                onSelect = {
                    onOrderChange(verseOrder.copy(OrderType.Ascending))
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(text = "Descending",
                selected = verseOrder.orderType is OrderType.Descending,
                onSelect = {
                    onOrderChange(verseOrder.copy(OrderType.Descending))
                }
            )
        }
    }
}