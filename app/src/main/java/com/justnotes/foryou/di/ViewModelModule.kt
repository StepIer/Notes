package com.justnotes.foryou.di

import com.justnotes.foryou.domain.usecase.AddNoteUseCase
import com.justnotes.foryou.domain.usecase.GetNoteUseCase
import com.justnotes.foryou.presentation.ui.login.LoginViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelModule {
    @Provides
    @Singleton
    fun provideLoginViewModel(addNoteUseCase: AddNoteUseCase, getNoteUseCase: GetNoteUseCase) = LoginViewModel(addNoteUseCase, getNoteUseCase)
}