package com.compose.redesign.scooter.domain

import androidx.annotation.IdRes

data class PromotedItem(
    val id: Int,
    val title: String,
    val category: String,
    val itemColor: androidx.ui.graphics.Color,
    @IdRes val image: Int
)