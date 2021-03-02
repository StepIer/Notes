package com.justnotes.foryou.presentation

import android.app.Application
import com.justnotes.foryou.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class NotesApplication: DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

       return DaggerApplicationComponent.builder().application(this).build()

    }


}