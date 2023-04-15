package com.example.gitagyan.database.data.data_source

import androidx.room.*
import com.example.gitagyan.database.domain.model.Verse
import kotlinx.coroutines.flow.Flow

@Dao
interface VerseDao {

    @Query("SELECT * FROM verse")
    fun getVerses() : Flow<List<Verse>>

    @Query("SELECT * FROM verse WHERE id = :id")
    suspend fun getVerseById(id : Int) : Verse?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVerse(verse: Verse)

    @Delete
    suspend fun deleteVerse(verse: Verse)
}