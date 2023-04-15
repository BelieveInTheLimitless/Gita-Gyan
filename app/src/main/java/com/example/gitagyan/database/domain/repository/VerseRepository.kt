package com.example.gitagyan.database.domain.repository

import com.example.gitagyan.database.domain.model.Verse
import kotlinx.coroutines.flow.Flow

interface VerseRepository {

    fun getVerses() : Flow<List<Verse>>

    suspend fun getVerseById(id : Int) : Verse?

    suspend fun insertVerse(verse: Verse)

    suspend fun deleteVerse(verse: Verse)
}