package com.example.gitagyan.screens.save.presentation.verses

import com.example.gitagyan.database.domain.model.Verse
import com.example.gitagyan.database.domain.util.OrderType
import com.example.gitagyan.database.domain.util.VerseOrder

data class VersesState(
    val verses : List<Verse> = emptyList(),
    val verseOrder: VerseOrder = VerseOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
