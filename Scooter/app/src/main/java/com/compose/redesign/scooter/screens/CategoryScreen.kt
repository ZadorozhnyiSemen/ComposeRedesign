package com.compose.redesign.scooter.screens

import androidx.compose.Composable
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.material.Scaffold
import androidx.ui.material.Surface
import androidx.ui.material.TopAppBar
import androidx.ui.res.vectorResource
import com.compose.redesign.scooter.R
import com.compose.redesign.scooter.kit.GridItems
import com.compose.redesign.scooter.kit.categories
import com.compose.redesign.scooter.styles.colorWhite

@Composable
fun CategoryScreen(categoryId: Int) {
    val item = categories.flatMap { it.items }.find { it.id == categoryId }
        ?: throw IllegalArgumentException()
    Scaffold {
        Surface {
            VerticalScroller {
                Column {
                    TopAppBar(backgroundColor = colorWhite) {
                        val backButton = vectorResource(id = R.drawable.ic_back_24)
                        val search = vectorResource(id = R.drawable.ic_search_24)
                        Image(asset = backButton)
                        Text(text = item.title)
                        Image(asset = search)
                    }

                    GridItems(item.items)
                }
            }
        }
    }
}