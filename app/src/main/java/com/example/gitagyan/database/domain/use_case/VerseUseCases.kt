package com.example.gitagyan.database.domain.use_case

data class VerseUseCases(
    val getVerses: GetVerses,
    val deleteVerse: DeleteVerse,
    val addVerse: AddVerse,
    val getVerse: GetVerse
)
