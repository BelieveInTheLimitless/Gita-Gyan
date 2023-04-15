package com.example.gitagyan.screens.save.presentation.verses

import com.example.gitagyan.database.domain.model.Verse
import com.example.gitagyan.database.domain.util.VerseOrder

sealed class VersesEvent{
    data class Order(val verseOrder: VerseOrder): VersesEvent()
    data class DeleteVerse(val verse: Verse): VersesEvent()
    object RestoreVerse: VersesEvent()
    object ToggleOrderSection: VersesEvent()
}
