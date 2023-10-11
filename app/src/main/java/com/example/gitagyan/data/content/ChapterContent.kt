package com.example.gitagyan.data.content

data class Chapter(
    val chapterId : String,
    val chapter: String,
    val chapterName : String,
    val description : String,
    val chapterContent : List<Verse>,
    val totalVerses : String,
)
