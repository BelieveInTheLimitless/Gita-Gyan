package com.example.gitagyan.data.english

data class Chapter(
    val chapterLanguage : String,
    val chapterId : String,
    val chapterName : String,
    val description : String,
    val chapterContent : List<Verse>,
    val totalVerses : String,
)