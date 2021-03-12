package com.justnotes.foryou.di

import com.justnotes.foryou.domain.repository.NotesRepository
import com.justnotes.foryou.domain.usecase.AddNoteUseCase
import com.justnotes.foryou.domain.usecase.DeleteNoteUseCase
import com.justnotes.foryou.domain.usecase.GetNoteUseCase
import com.justnotes.foryou.domain.usecase.InsertNoteUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class UseCaseModule {
    @Provides
    @Singleton
    fun addNoteUseCase(notesRepository: NotesRepository) = AddNoteUseCase(notesRepository)

    @Provides
    @Singleton
    fun deleteNoteUseCase(notesRepository: NotesRepository) = DeleteNoteUseCase(notesRepository)

    @Provides
    @Singleton
    fun getNoteUseCase(notesRepository: NotesRepository) = GetNoteUseCase(notesRepository)

    @Provides
    @Singleton
    fun insertNoteUseCase(notesRepository: NotesRepository) = InsertNoteUseCase(notesRepository)
}