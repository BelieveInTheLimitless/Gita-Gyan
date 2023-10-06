package com.example.gitagyan.repository

import com.example.gitagyan.data.dao.FavouriteDao
import com.example.gitagyan.model.Favourite
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavouriteRepository @Inject constructor(private val favouriteDao: FavouriteDao) {

    fun getFavourites(): Flow<List<Favourite>> = favouriteDao.getFavourites()

    suspend fun insertFavourite(favourite: Favourite) = favouriteDao.insertFavourite(favourite)

//    suspend fun updateFavourite(favourite: Favourite) = favouriteDao.updateFavourite(favourite)

//    suspend fun deleteAllFavourites() = favouriteDao.deleteAllFavourites()

    suspend fun deleteFavourite(favourite: Favourite) = favouriteDao.deleteFavourite(favourite)

//    suspend fun getFavById(chapterId: String): Favourite = favouriteDao.getFavByChapterId(chapterId)

}