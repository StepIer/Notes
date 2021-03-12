package com.justnotes.foryou.di

import android.app.Application
import android.content.Context
import com.justnotes.foryou.data.db.DbHelper
import com.justnotes.foryou.data.repository.NotesRepositoryImpl
import com.justnotes.foryou.domain.repository.NotesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {
    @Provides
    fun provideContext(application: Application) = application.applicationContext

    @Provides
    @Singleton
    fun provideDbHelper(context: Context) = DbHelper(context, null)

    @Provides
    @Singleton
    fun provideNoteRepository(dbHelper: DbHelper): NotesRepository = NotesRepositoryImpl(dbHelper)
}