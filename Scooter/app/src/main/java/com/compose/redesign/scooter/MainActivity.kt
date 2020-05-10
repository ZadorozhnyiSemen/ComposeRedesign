package com.compose.redesign.scooter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Box
import androidx.ui.foundation.ContentGravity
import androidx.ui.foundation.Image
import androidx.ui.layout.fillMaxHeight
import androidx.ui.layout.preferredSize
import androidx.ui.material.BottomNavigation
import androidx.ui.res.vectorResource
import androidx.ui.unit.dp
import com.compose.redesign.scooter.screens.MainScreen
import com.compose.redesign.scooter.screens.colorWhite

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()

            BottomNavigation(backgroundColor = colorWhite) {
                val icon = vectorResource(id = R.drawable.ic_search)
                // TODO: Refactor as BottomNavItem
                Box(
                    gravity = ContentGravity.Center,
                    modifier = Modifier.weight(1f).fillMaxHeight()
                ) {
                    Image(
                        modifier = Modifier.preferredSize(24.dp),
                        contentScale = ContentScale.Inside,
                        asset = icon
                    )
                }
                Box(
                    gravity = ContentGravity.Center,
                    modifier = Modifier.weight(1f).fillMaxHeight()
                ) {
                    Image(
                        modifier = Modifier.preferredSize(24.dp),
                        contentScale = ContentScale.Inside,
                        asset = icon
                    )
                }
                Box(
                    gravity = ContentGravity.Center,
                    modifier = Modifier.weight(1f).fillMaxHeight()
                ) {
                    Image(
                        modifier = Modifier.preferredSize(24.dp),
                        contentScale = ContentScale.Inside,
                        asset = icon
                    )
                }
                Box(
                    gravity = ContentGravity.Center,
                    modifier = Modifier.weight(1f).fillMaxHeight()
                ) {
                    Image(
                        modifier = Modifier.preferredSize(24.dp),
                        contentScale = ContentScale.Fit,
                        asset = icon
                    )
                }
            }
        }
    }
}
