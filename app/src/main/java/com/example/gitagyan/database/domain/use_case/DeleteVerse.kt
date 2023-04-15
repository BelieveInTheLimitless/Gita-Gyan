package com.example.gitagyan.database.domain.use_case

import com.example.gitagyan.database.domain.model.Verse
import com.example.gitagyan.database.domain.repository.VerseRepository

class DeleteVerse(
    private val repository: VerseRepository
) {
    suspend operator fun invoke(verse: Verse){
        repository.deleteVerse(verse)
    }
}