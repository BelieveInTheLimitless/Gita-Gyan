package com.example.gitagyan.database.domain.use_case

import com.example.gitagyan.database.domain.model.Verse
import com.example.gitagyan.database.domain.repository.VerseRepository

class GetVerse(
    private val repository: VerseRepository
) {
    suspend operator fun invoke(id : Int) : Verse?{
        return repository.getVerseById(id)
    }
}