package com.example.gitagyan.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "current_verse_table",
    primaryKeys = ["chapter", "verse"])
data class CurrentVerse(
    @NonNull
    @ColumnInfo(name = "chapter")
    val chapterId: Int,

    @NonNull
    @ColumnInfo(name = "verse")
    val verseId: Int
)
