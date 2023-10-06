package com.example.gitagyan.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gitagyan.model.Favourite

@Database(entities = [Favourite::class], version = 1, exportSchema = false)
abstract class FavouriteDatabase: RoomDatabase() {
    abstract fun favouriteDao(): FavouriteDao
}