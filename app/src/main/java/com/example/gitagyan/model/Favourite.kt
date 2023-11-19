package com.example.gitagyan.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "favourite_table",
    primaryKeys = ["chapter", "verse"])
data class Favourite(

    @NonNull
    @ColumnInfo(name = "chapter")
    val chapterId: Int,

    @NonNull
    @ColumnInfo(name = "verse")
    val verseId: Int
)
