package com.justnotes.foryou.di

import com.justnotes.foryou.domain.Note
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class NotesModule {
    @Provides
    fun provideNote(text: String): Note = Note(text)
    @Provides
    fun provideNoteName(): String = "New NoteName"


}