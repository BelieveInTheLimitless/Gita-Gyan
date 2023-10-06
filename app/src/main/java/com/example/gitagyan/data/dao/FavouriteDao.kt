package com.example.gitagyan.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.gitagyan.model.Favourite
import kotlinx.coroutines.flow.Flow


@Dao
interface FavouriteDao {
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
}

