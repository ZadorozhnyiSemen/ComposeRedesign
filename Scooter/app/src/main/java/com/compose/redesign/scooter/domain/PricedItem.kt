package com.compose.redesign.scooter.domain

import androidx.annotation.IdRes

data class PricedItem(
    val id: Int,
    val saleValue: Float,
    private val itemPrice: Float,
    @IdRes val image: Int
) {
    private val onSale: Boolean
        get() = saleValue != 0f
    val price: Float
        get() = if (onSale) itemPrice - itemPrice * saleValue else itemPrice
}