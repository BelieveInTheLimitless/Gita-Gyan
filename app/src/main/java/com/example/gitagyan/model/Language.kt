package com.example.gitagyan.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "language_table")
data class Language(
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "language")
    val language: String
)