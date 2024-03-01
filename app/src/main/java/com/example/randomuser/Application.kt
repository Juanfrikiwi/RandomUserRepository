package com.example.randomuser

import android.app.Application
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Application : Application(), Configuration.Provider {

    override fun getWorkManagerConfiguration(): Configuration =
        Configuration.Builder()
            .build()
}
