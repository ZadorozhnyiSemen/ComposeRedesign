package com.compose.redesign.scooter

import android.app.Application
import com.compose.redesign.scooter.data.AppContainer
import com.compose.redesign.scooter.data.AppContainerImpl

class ScooterApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainerImpl(this)
    }
}