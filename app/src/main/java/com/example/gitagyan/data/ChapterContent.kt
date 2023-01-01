package com.example.gitagyan.data

import com.example.gitagyan.data.english.Verse

data class Chapter(
    val chapter_language : String,
    val chapter_id : String,
    val chapter_name : String,
    val description : String,
    val chapter_content : List<Verse>,
    val total_verses : String,
)