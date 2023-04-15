package com.example.gitagyan.database.data.repository

import com.example.gitagyan.database.data.data_source.VerseDao
import com.example.gitagyan.database.domain.model.Verse
import com.example.gitagyan.database.domain.repository.VerseRepository
import kotlinx.coroutines.flow.Flow

class VerseRepositoryImplementation(
    private val dao : VerseDao
) : VerseRepository {

    override fun getVerses(): Flow<List<Verse>> {
        return dao.getVerses()
    }

    override suspend fun getVerseById(id: Int): Verse? {
        return dao.getVerseById(id)
    }

    override suspend fun insertVerse(verse: Verse) {
        dao.insertVerse(verse)
    }

    override suspend fun deleteVerse(verse: Verse) {
        dao.deleteVerse(verse)
    }
}