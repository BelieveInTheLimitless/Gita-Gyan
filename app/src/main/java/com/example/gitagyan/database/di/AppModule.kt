package com.example.gitagyan.database.di

import android.app.Application
import androidx.room.Room
import com.example.gitagyan.database.data.data_source.VerseDatabase
import com.example.gitagyan.database.data.repository.VerseRepositoryImplementation
import com.example.gitagyan.database.domain.repository.VerseRepository
import com.example.gitagyan.database.domain.use_case.AddVerse
import com.example.gitagyan.database.domain.use_case.DeleteVerse
import com.example.gitagyan.database.domain.use_case.GetVerses
import com.example.gitagyan.database.domain.use_case.VerseUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideVerseDatabase(app: Application): VerseDatabase{
        return Room.databaseBuilder(
            app,
            VerseDatabase::class.java,
            VerseDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideVerseRepository(db: VerseDatabase): VerseRepository {
        return VerseRepositoryImplementation(db.verseDao)
    }

    @Provides
    @Singleton
    fun provideVerseUseCases(repository: VerseRepository): VerseUseCases {
        return VerseUseCases(
            getVerses = GetVerses(repository),
            deleteVerse = DeleteVerse(repository),
            addVerse = AddVerse(repository),
            getVerse = GetVerse(repository)
        )
    }
}