package com.example.gitagyan.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.gitagyan.model.Favourite
import com.example.gitagyan.model.Language
import kotlinx.coroutines.flow.Flow


@Dao
interface GitaDao {
    @Query("SELECT * from favourite_table")
    fun getFavourites(): Flow<List<Favourite>>

//    @Query("SELECT * from favourite_table where chapter =:chapterId")
//    suspend fun getFavByChapterId(chapterId: String): Favourite

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavourite(favourite: Favourite)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateFavourite(favourite: Favourite)

    @Query("DELETE from favourite_table")
    suspend fun deleteAllFavourites()

    @Delete
    suspend fun deleteFavourite(favourite: Favourite)

    //Language
    @Query("SELECT * from language_table")
    fun getLanguages(): Flow<List<Language>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLanguage(language: Language)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateLanguage(language: Language)

    @Query("DELETE from language_table")
    suspend fun deleteAllLanguages()

    @Delete
    suspend fun deleteLanguage(language: Language)
}

