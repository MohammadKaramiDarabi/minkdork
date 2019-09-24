package com.example.mindork.di.builder

import com.example.mindork.ui.splash.SplashActivityModule
import com.example.mindork.ui.splash.view.SplashMVPActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    abstract fun bindSplashActivity() : SplashMVPActivity
}