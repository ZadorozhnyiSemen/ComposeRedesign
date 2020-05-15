package com.compose.redesign.scooter.kit

import android.content.res.Configuration
import androidx.compose.Composable
import androidx.ui.core.ContextAmbient
import androidx.ui.core.Modifier
import androidx.ui.foundation.HorizontalScroller
import androidx.ui.layout.Arrangement
import androidx.ui.layout.Column
import androidx.ui.layout.Row
import androidx.ui.layout.fillMaxWidth
import androidx.ui.unit.dp
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
    Column() {
        for (i in items.indices step 2) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                StoreItem(
                    item = items[i],
                    showDescription = true,
                    height = 244.dp,
                    elevation = 0.dp
                )
                if (i + 1 != items.size) StoreItem(
                    item = items[i + 1],
                    showDescription = true,
                    height = 244.dp,
                    elevation = 0.dp
                )
            }
        }
    }
}

@Composable
fun HorizontalGrid(items: List<PricedItem>) {
    HorizontalScroller {
        Row {
            items.forEach {
                StoreItem(
                    item = it,
                    showDescription = true,
                    height = 244.dp,
                    elevation = 0.dp
                )
            }
        }
    }
}