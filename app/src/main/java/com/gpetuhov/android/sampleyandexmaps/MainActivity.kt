package com.gpetuhov.android.sampleyandexmaps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Yandex key is taken from ~/.gradle/gradle.properties file
        // into BuildConfig inside the build.gradle script.
        MapKitFactory.setApiKey(BuildConfig.YandexKey)

        // It is NOT recommended to call this in Application.onCreate()
        MapKitFactory.initialize(this)

        setContentView(R.layout.activity_main)

        mapview.map.move(
            CameraPosition(Point(55.751574, 37.573856), 11.0f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 0F),
            null
        )
    }

    // Don't forget to start/stop map in onStart and onStop
    override fun onStart() {
        super.onStart()
        mapview.onStart()
        MapKitFactory.getInstance().onStart()
    }

    override fun onStop() {
        super.onStop()
        mapview.onStop()
        MapKitFactory.getInstance().onStop()
    }
}
