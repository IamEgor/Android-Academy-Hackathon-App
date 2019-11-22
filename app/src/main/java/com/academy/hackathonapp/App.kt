package com.academy.hackathonapp

import android.app.Application
import android.content.ContextWrapper
import com.pixplicity.easyprefs.library.Prefs

class App : Application() {

    companion object {
        const val PREFS_NAME = "SHARED_PREFS"
    }

    override fun onCreate() {
        super.onCreate()
        Prefs.Builder()
            .setContext(this)
            .setMode(ContextWrapper.MODE_PRIVATE)
            .setPrefsName(PREFS_NAME)
            .setUseDefaultSharedPreference(true)
            .build()
    }
}