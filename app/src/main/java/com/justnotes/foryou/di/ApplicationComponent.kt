package com.justnotes.foryou.di

import android.app.Application
import com.justnotes.foryou.presentation.NavFragment
import com.justnotes.foryou.presentation.NotesApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [NotesModule::class, AndroidSupportInjectionModule::class, BuildersModule::class])
interface ApplicationComponent: AndroidInjector<NotesApplication> {


    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}