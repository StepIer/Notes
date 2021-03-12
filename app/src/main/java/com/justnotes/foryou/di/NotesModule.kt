package com.justnotes.foryou.di

import com.justnotes.foryou.domain.entity.Note
import dagger.Module
import dagger.Provides

@Module
class NotesModule {
    @Provides
    fun provideNote(text: String): Note = Note(0, " ", text)
    @Provides
    fun provideNoteName(): String = "New NoteName"



}