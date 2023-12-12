package com.adrian.procastiless

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ProcrastilessApp: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}