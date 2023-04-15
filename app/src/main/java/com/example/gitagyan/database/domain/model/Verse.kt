package com.example.gitagyan.database.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Verse(
    val chapterId : String,
    val verseId : String,
    val timestamp : Long,
    @PrimaryKey val id : Int? = null
)
