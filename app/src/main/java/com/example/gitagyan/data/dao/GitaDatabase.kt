package com.example.gitagyan.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gitagyan.model.Favourite
import com.example.gitagyan.model.Language

@Database(entities = [Favourite::class, Language::class], version = 2, exportSchema = false)
abstract class GitaDatabase: RoomDatabase() {
    abstract fun gitaDao(): GitaDao
}