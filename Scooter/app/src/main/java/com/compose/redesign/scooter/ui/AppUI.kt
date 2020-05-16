package com.compose.redesign.scooter.ui

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.layout.Column
import androidx.ui.material.*
import androidx.ui.res.vectorResource
import androidx.ui.text.style.TextOverflow
import com.compose.redesign.scooter.data.AppContainer
import com.compose.redesign.scooter.data.items.ItemsRepository
import com.compose.redesign.scooter.screens.CatalogScreen
import com.compose.redesign.scooter.screens.CategoryScreen
import com.compose.redesign.scooter.screens.DummyScreen
import com.compose.redesign.scooter.screens.MainScreen
import com.compose.redesign.scooter.styles.*

@Composable
fun ScooterApp(container: AppContainer) {
    MaterialTheme(
        typography = Typography(

        )
    ) {
        AppContent(
            itemsRepository = container.itemsRepository
        )
    }
}

@Composable
private fun AppContent(
    itemsRepository: ItemsRepository
) {
    Column {
        Surface(modifier = Modifier.weight(1f), color = colorBackground) {
            when (val screen = AppStatus.currentScreen) {
                Screen.Home -> MainScreen()
                Screen.Catalog -> CatalogScreen()
                Screen.Cart -> DummyScreen(screenName = "Empty")
                Screen.Chat -> DummyScreen(screenName = "Empty")
                Screen.Account -> DummyScreen(screenName = "Empty")
                is Screen.Category -> CategoryScreen(categoryId = screen.categoryId)
            }
        }

        BottomNavigation(backgroundColor = colorWhite, contentColor = colorAccent) {
            MenuItem.values().forEachIndexed { index, item ->
                BottomNavigationItem(
                    icon = { Icon(vectorResource(id = item.icon)) },
                    selected = AppStatus.currentScreen.indexFor() == index,
                    onSelected = {
                        AppStatus.currentScreen = Screen.fromMenuItem(item)
                    },
                    text = {
                        Text(
                            text = item.title,
                            overflow = TextOverflow.Ellipsis,
                            style = typographyCaptionNavbar(colorAccent)
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
