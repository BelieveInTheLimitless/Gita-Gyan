package com.example.gitagyan.di

import android.content.Context
import androidx.room.Room
import com.example.gitagyan.data.dao.GitaDao
import com.example.gitagyan.data.dao.GitaDatabase
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
    fun provideGitaDao(gitaDatabase: GitaDatabase): GitaDao =
        gitaDatabase.gitaDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): GitaDatabase =
        Room.databaseBuilder(
            context,
            GitaDatabase::class.java,
            "gita_database"
        ).fallbackToDestructiveMigration()
            .build()
}
