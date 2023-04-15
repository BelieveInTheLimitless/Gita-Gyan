package com.example.gitagyan.database.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gitagyan.database.domain.model.Verse

@Database(
    entities = [Verse::class],
    version = 1
)

abstract class VerseDatabase : RoomDatabase() {

    abstract val verseDao : VerseDao

    companion object{
        const val DATABASE_NAME = "verses_db"
    }
}