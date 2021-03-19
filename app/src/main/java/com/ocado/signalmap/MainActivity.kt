package com.ocado.signalmap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.here.sdk.core.GeoCoordinates
import com.here.sdk.mapviewlite.MapStyle
import com.ocado.signalmap.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mapView.onCreate(savedInstanceState)

        loadMapScene()
    }

    private fun loadMapScene() {
        binding.mapView.mapScene.loadScene(MapStyle.NORMAL_DAY) { errorCode ->
            if (errorCode == null) {
                binding.mapView.camera.apply {
                    target = GeoCoordinates(52.0, 0.0)
                    zoomLevel = 14.0
                }
                Log.e("yay", "map scene loaded successfully")
            } else {
                Log.e("boo", "failed to load map scene: ${errorCode.toString()}")
            }
        }
    }
}