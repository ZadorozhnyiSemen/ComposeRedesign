package com.compose.redesign.scooter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.ui.core.setContent
import com.compose.redesign.scooter.ui.AppStatus
import com.compose.redesign.scooter.ui.ScooterApp
import com.compose.redesign.scooter.ui.Screen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val container = (application as ScooterApplication).container
        setContent {
            ScooterApp(container)
        }
    }

    override fun onBackPressed() {
        when (AppStatus.currentScreen) {
            is Screen.Category -> AppStatus.currentScreen = Screen.Catalog
            else -> super.onBackPressed()
        }
    }
}

