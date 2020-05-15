package com.compose.redesign.scooter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.ui.core.setContent
import com.compose.redesign.scooter.ui.ScooterApp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val container = (application as ScooterApplication).container
        setContent {
            ScooterApp(container)
        }
    }
}

