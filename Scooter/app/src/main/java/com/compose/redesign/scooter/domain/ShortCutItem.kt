package com.compose.redesign.scooter.domain

import androidx.annotation.IdRes

data class ShortCutItem(
    val id: Int,
    val title: String,
    val subtitle: String,
    @IdRes val icon: Int
)