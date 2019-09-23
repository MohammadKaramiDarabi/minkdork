package com.example.mindork

import android.app.Application
import com.example.mindork.di.component.DaggerAppComponent

class MvpApp: Application() {

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)


    }
}