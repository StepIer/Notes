package com.justnotes.foryou.di

import com.justnotes.foryou.presentation.ui.MainActivity
import com.justnotes.foryou.presentation.NavFragment
import com.justnotes.foryou.presentation.ui.login.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector(modules = [])
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [])
    abstract fun contributeNavFragment(): NavFragment

    @ContributesAndroidInjector(modules = [])
    abstract fun contributeLoginFragment(): LoginFragment


}