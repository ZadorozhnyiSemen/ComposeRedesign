package com.compose.redesign.scooter.kit

import android.content.res.Configuration
import androidx.compose.Composable
import androidx.ui.core.ContextAmbient
import androidx.ui.foundation.HorizontalScroller
import androidx.ui.layout.Column
import androidx.ui.layout.Row
import com.compose.redesign.scooter.domain.PricedItem

@Composable
fun GridItems(items: List<PricedItem>) {
    val orientation = ContextAmbient.current.resources.configuration.orientation

    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
        VerticalGrid(items = items)
    } else {
        HorizontalGrid(items = items)
    }
}

@Composable
fun VerticalGrid(items: List<PricedItem>) {
    Column {
        for (i in items.indices step 2) {
            Row {
                StoreItem(item = items[i])
                StoreItem(item = items[i + 1])
            }
        }
    }
}

@Composable
fun HorizontalGrid(items: List<PricedItem>) {
    HorizontalScroller {
        Row {
            items.forEach {
                StoreItem(item = it)
            }
        }
    }
}