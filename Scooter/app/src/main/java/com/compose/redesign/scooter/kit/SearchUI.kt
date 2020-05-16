package com.compose.redesign.scooter.kit

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.Row
import androidx.ui.layout.fillMaxWidth
import androidx.ui.layout.padding
import androidx.ui.layout.size
import androidx.ui.material.Card
import androidx.ui.res.vectorResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.compose.redesign.scooter.R
import com.compose.redesign.scooter.styles.textSecondary_3
import com.compose.redesign.scooter.styles.typographyText

@Composable
@Preview
fun SearchBar() {
    val icon = vectorResource(R.drawable.ic_search)
    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        shape = RoundedCornerShape(6.dp),
        elevation = 2.dp
    ) {
        Row(verticalGravity = Alignment.CenterVertically) {
            Icon(
                modifier = Modifier.padding(
                    start = 12.dp,
                    end = 12.dp,
                    top = 10.dp,
                    bottom = 10.dp
                ).size(24.dp), asset = icon
            )
            Text(
                modifier = Modifier.weight(weight = 1f),
                text = "Поиск товаров",
                style = typographyText(textSecondary_3)
            )
        }
    }
}
