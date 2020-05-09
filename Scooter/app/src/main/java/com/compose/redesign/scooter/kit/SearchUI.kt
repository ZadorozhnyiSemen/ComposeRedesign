package com.compose.redesign.scooter.kit

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.foundation.*
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.BlendMode
import androidx.ui.graphics.Color
import androidx.ui.graphics.ColorFilter
import androidx.ui.graphics.vector.VectorAsset
import androidx.ui.layout.*
import androidx.ui.material.Card
import androidx.ui.material.IconButton
import androidx.ui.res.imageResource
import androidx.ui.res.vectorResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.compose.redesign.scooter.R
import com.compose.redesign.scooter.screens.textStyleAdditional

@Composable
@Preview
fun SearchBar() {
    val icon = vectorResource(R.drawable.ic_search)
    Card(
        modifier = Modifier.fillMaxWidth().wrapContentHeight(align = Alignment.CenterVertically).padding(start = 16.dp, end = 16.dp, top = 16.dp),
        shape = RoundedCornerShape(6.dp)
    ) {
        Row(verticalGravity = Alignment.CenterVertically) {
            Icon(modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 10.dp, bottom = 10.dp).size(24.dp), asset = icon)
            Text(modifier = Modifier.weight(weight = 1f), text = "Поиск", style = textStyleAdditional)
        }
    }
}