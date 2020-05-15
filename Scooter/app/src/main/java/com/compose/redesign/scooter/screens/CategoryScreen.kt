package com.compose.redesign.scooter.screens

import androidx.compose.Composable
import androidx.ui.foundation.Text

@Composable
fun CategoryScreen(categoryId: Int) {
    Text(text = categoryId.toString())
}