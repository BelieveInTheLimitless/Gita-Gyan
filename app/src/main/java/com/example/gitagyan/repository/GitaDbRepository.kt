package com.example.gitagyan.repository

import com.example.gitagyan.data.dao.GitaDao
import com.example.gitagyan.model.CurrentVerse
import com.example.gitagyan.model.Favourite
import com.example.gitagyan.model.Language
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GitaDbRepository @Inject constructor(private val gitaDao: GitaDao) {

    fun getFavourites(): Flow<List<Favourite>> = gitaDao.getFavourites()

    suspend fun insertFavourite(favourite: Favourite) = gitaDao.insertFavourite(favourite)

//    suspend fun updateFavourite(favourite: Favourite) = favouriteDao.updateFavourite(favourite)

//    suspend fun deleteAllFavourites() = favouriteDao.deleteAllFavourites()

    suspend fun deleteFavourite(favourite: Favourite) = gitaDao.deleteFavourite(favourite)

//    suspend fun getFavById(chapterId: String): Favourite = favouriteDao.getFavByChapterId(chapterId)

    //Language
    fun getLanguages(): Flow<List<Language>> = gitaDao.getLanguages()

    suspend fun insertLanguage(language: Language) = gitaDao.insertLanguage(language)

    suspend fun updateLanguage(language: Language) = gitaDao.updateLanguage(language)

    suspend fun deleteAllLanguages() = gitaDao.deleteAllLanguages()

    suspend fun deleteLanguage(language: Language) = gitaDao.deleteLanguage(language)

//    Current Verse
    fun getCurrentVerse(): Flow<List<CurrentVerse>> = gitaDao.getCurrentVerse()

    suspend fun insertCurrentVerse(currentVerse: CurrentVerse) = gitaDao.insertCurrentVerse(currentVerse)

    suspend fun updateCurrentVerse(currentVerse: CurrentVerse) = gitaDao.updateCurrentVerse(currentVerse)

    suspend fun deleteAllCurrentVerses() = gitaDao.deleteAllCurrentVerses()

    suspend fun deleteCurrentVerse(currentVerse: CurrentVerse) = gitaDao.deleteCurrentVerse(currentVerse)

}