package com.example.gitagyan.di

import android.content.Context
import androidx.room.Room
import com.example.gitagyan.data.dao.FavouriteDao
import com.example.gitagyan.data.dao.FavouriteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent:: class)
class AppModule {

    @Singleton
    @Provides
    fun provideFavouriteDao(favouriteDatabase: FavouriteDatabase): FavouriteDao =
        favouriteDatabase.favouriteDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): FavouriteDatabase =
        Room.databaseBuilder(
            context,
            FavouriteDatabase::class.java,
            "favourite_database"
        ).fallbackToDestructiveMigration()
            .build()
}
