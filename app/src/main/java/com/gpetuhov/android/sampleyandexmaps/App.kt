package com.gpetuhov.android.sampleyandexmaps

import android.app.Application
import com.yandex.mapkit.MapKitFactory

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // Yandex key is taken from ~/.gradle/gradle.properties file
        // into BuildConfig inside the build.gradle script.
        // It is recommended to call this in Application.onCreate()
        MapKitFactory.setApiKey(BuildConfig.YandexKey)
    }
}