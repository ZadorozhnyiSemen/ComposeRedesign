package com.compose.redesign.scooter.screens

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.ContentGravity
import androidx.ui.foundation.Text
import androidx.ui.layout.fillMaxSize
import androidx.ui.material.Scaffold

@Composable
fun DummyScreen(screenName: String) {
    Scaffold {
        Box(modifier = Modifier.fillMaxSize(), gravity = ContentGravity.Center) {
            Text(text = screenName)
        }
    }
}