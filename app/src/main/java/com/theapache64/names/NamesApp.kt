package com.theapache64.names

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * Created by theapache64 : Aug 29 Sat,2020 @ 10:04
 */
@HiltAndroidApp
class NamesApp : Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}