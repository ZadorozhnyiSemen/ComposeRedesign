package com.compose.redesign.scooter.ui

import androidx.annotation.IdRes
import androidx.compose.Model
import com.compose.redesign.scooter.R

@Model
object AppStatus {
    var currentScreen: Screen = Screen.Home
}

fun navigateTo(screen: Screen) {
    AppStatus.currentScreen = screen
}

sealed class Screen {
    object Home : Screen()
    object Catalog : Screen()
    object Cart : Screen()
    object Chat : Screen()
    object Account : Screen()
    data class Category(val categoryId: Int) : Screen()

    fun indexFor(): Int = when (this) {
        Home -> 0
        Catalog, is Category -> 1
        Cart -> 2
        Chat -> 3
        Account -> 4
    }

    companion object {
        fun fromMenuItem(item: MenuItem): Screen {
            return when (item) {
                MenuItem.HOME -> Home
                MenuItem.CATALOG -> Catalog
                MenuItem.CART -> Cart
                MenuItem.CHAT -> Chat
                MenuItem.ACCOUNT -> Account
            }
        }
    }
}

enum class MenuItem(
    val id: Int,
    val title: String = "",
    @IdRes val icon: Int = -1
) {
    HOME(0, "Акции", R.drawable.ic_nav_home),
    CATALOG(1, "Каталог", R.drawable.ic_nav_catalog),
    CART(2, "Корзина", R.drawable.ic_nav_cart),
    CHAT(3, "Помощь", R.drawable.ic_nav_chat),
    ACCOUNT(4, "Аккаунт", R.drawable.ic_nav_account)
}