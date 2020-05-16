package com.compose.redesign.scooter.kit

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.material.Surface
import androidx.ui.res.vectorResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.compose.redesign.scooter.R
import com.compose.redesign.scooter.styles.colorAccent
import com.compose.redesign.scooter.styles.colorWhite
import com.compose.redesign.scooter.styles.typographyCaptionSemi

@Composable
@Preview
fun ItemFilter() {
    val selectedChip = state { 0 }
    Surface(elevation = 3.dp) {
        Row(
            Modifier.fillMaxWidth().padding(start = 16.dp, end = 8.dp, top = 8.dp, bottom = 8.dp),
            verticalGravity = Alignment.CenterVertically
        ) {
            val filterIcon = vectorResource(id = R.drawable.ic_filter_24)
            Clickable(onClick = { selectedChip.value = 0 }) {
                Chip(text = "Все", active = selectedChip.value == 0)
            }
            Spacer(modifier = Modifier.width(4.dp))
            Clickable(onClick = { selectedChip.value = 1 }) {
                Chip("Со скидкой", active = selectedChip.value == 1)
            }
            Spacer(modifier = Modifier.weight(1f))
            Image(asset = filterIcon, modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun Chip(
    text: String,
    active: Boolean = false
) {
    Box(
        backgroundColor = if (active) colorAccent else colorWhite,
        shape = RoundedCornerShape(100.dp)
    ) {
        val style = if (active) {
            typographyCaptionSemi(colorWhite)
        } else {
            typographyCaptionSemi(colorAccent)
        }
        Text(
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp,
                top = 8.dp,
                bottom = 8.dp
            ), text = text, style = style
        )
    }
}