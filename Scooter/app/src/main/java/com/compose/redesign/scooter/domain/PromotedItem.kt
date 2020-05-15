package com.compose.redesign.scooter.domain

import androidx.annotation.IdRes
import androidx.ui.graphics.Color

data class PromotedItem(
    val id: Int,
    val title: String,
    val category: String,
    val itemColor: androidx.ui.graphics.Color,
    @IdRes val image: Int
) {
    companion object {
        fun mock(): PromotedItem = PromotedItem(1, "", "", Color.Blue, -1)
    }
}