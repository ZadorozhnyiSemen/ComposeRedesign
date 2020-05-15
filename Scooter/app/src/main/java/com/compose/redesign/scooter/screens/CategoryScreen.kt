package com.compose.redesign.scooter.screens

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxHeight
import androidx.ui.layout.padding
import androidx.ui.material.Scaffold
import androidx.ui.material.Surface
import androidx.ui.material.TopAppBar
import androidx.ui.material.ripple.ripple
import androidx.ui.res.vectorResource
import androidx.ui.unit.dp
import com.compose.redesign.scooter.R
import com.compose.redesign.scooter.kit.GridItems
import com.compose.redesign.scooter.kit.ItemFilter
import com.compose.redesign.scooter.kit.categories
import com.compose.redesign.scooter.styles.colorWhite
import com.compose.redesign.scooter.styles.textStyleSecondaryHeader
import com.compose.redesign.scooter.ui.Screen
import com.compose.redesign.scooter.ui.navigateTo

@Composable
fun CategoryScreen(categoryId: Int) {
    val item = categories.flatMap { it.items }.find { it.id == categoryId }
        ?: throw IllegalArgumentException()
    Scaffold {
        Surface {
            Column {
                TopAppBar(
                    backgroundColor = colorWhite,
                    modifier = Modifier.gravity(Alignment.CenterHorizontally)
                ) {
                    val backButton = vectorResource(id = R.drawable.ic_back_24)
                    val search = vectorResource(id = R.drawable.ic_search_24)
                    val sizeModifier = Modifier.fillMaxHeight().padding(16.dp)
                    Clickable(
                        onClick = { navigateTo(Screen.Catalog) },
                        modifier = Modifier.ripple()
                    ) {
                        Image(modifier = sizeModifier, asset = backButton)
                    }

                    Text(
                        modifier = sizeModifier,
                        text = item.title,
                        style = textStyleSecondaryHeader
                    )
                    Image(modifier = sizeModifier, asset = search)
                }
                ItemFilter()
                VerticalScroller {
                    GridItems(item.items)
                }
            }
        }
    }
}