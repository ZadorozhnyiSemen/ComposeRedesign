package com.compose.redesign.scooter.domain

data class Category(
    val id: Int,
    val title: String,
    val items: List<CategoryItem>
)

data class CategoryItem(
    val id: Int,
    val title: String,
    val size: Int,
    val items: List<PricedItem>
)