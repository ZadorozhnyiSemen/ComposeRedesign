package com.compose.redesign.scooter.ui

import androidx.annotation.IdRes
import androidx.compose.Composable
import androidx.ui.animation.Crossfade
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.ContentGravity
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.layout.fillMaxSize
import androidx.ui.material.BottomNavigation
import androidx.ui.material.BottomNavigationItem
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.res.vectorResource
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.unit.sp
import com.compose.redesign.scooter.R
import com.compose.redesign.scooter.data.AppContainer
import com.compose.redesign.scooter.data.items.ItemsRepository
import com.compose.redesign.scooter.screens.DummyScreen
import com.compose.redesign.scooter.screens.MainScreen
import com.compose.redesign.scooter.styles.*

@Composable
fun ScooterApp(container: AppContainer) {
    MaterialTheme {
        AppContent(
            itemsRepository = container.itemsRepository
        )
    }
}

@Composable
private fun AppContent(
    itemsRepository: ItemsRepository
) {
    Crossfade(current = AppStatus.currentScreen) { screen ->
        Surface(color = colorBackground) {
            when (screen) {
                NavigationItem.HOME -> MainScreen()
                NavigationItem.CATALOG -> DummyScreen(screenName = screen.title)
                NavigationItem.CART -> DummyScreen(screenName = screen.title)
                NavigationItem.CHAT -> DummyScreen(screenName = screen.title)
                NavigationItem.ACCOUNT -> DummyScreen(screenName = screen.title)
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize(), gravity = ContentGravity.BottomCenter) {
        BottomNavigation(backgroundColor = colorWhite, contentColor = colorAccent) {
            NavigationItem.values().forEachIndexed { index, item ->
                BottomNavigationItem(
                    icon = { Icon(vectorResource(id = item.icon)) },
                    selected = AppStatus.currentScreen.id == index,
                    onSelected = {
                        //selectedItem = index
                        AppStatus.currentScreen = NavigationItem.values()[index]
                    },
                    text = {
                        Text(
                            text = item.title,
                            style = TextStyle(
                                fontSize = 11.sp,
                                fontFamily = appFontFamily,
                                fontWeight = FontWeight.W600,
                                fontStyle = FontStyle.Normal
                            )
                        )
                    },
                    alwaysShowLabels = false,
                    activeColor = colorAccent,
                    inactiveColor = textSecondary_5
                )
            }
        }
    }
}

enum class NavigationItem(
    val id: Int,
    val title: String,
    @IdRes val icon: Int
) {
    HOME(0, "Акции", R.drawable.ic_nav_home),
    CATALOG(1, "Каталог", R.drawable.ic_nav_catalog),
    CART(2, "Корзина", R.drawable.ic_nav_cart),
    CHAT(3, "Помощь", R.drawable.ic_nav_chat),
    ACCOUNT(4, "Аккаунт", R.drawable.ic_nav_account)
}