package com.compose.redesign.scooter.kit

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.layout.Row
import androidx.ui.layout.Spacer
import androidx.ui.layout.padding
import androidx.ui.layout.width
import androidx.ui.unit.dp
import com.compose.redesign.scooter.styles.textStyleAccent
import com.compose.redesign.scooter.styles.textStyleAdditional
import com.compose.redesign.scooter.styles.textStyleAdditionalDark

@Composable
fun DateAndAll() {
    Row(Modifier.padding(start = 16.dp, end = 16.dp)) {
        DateField(title = "Скидки", date = "1 - 7 Мая")
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Смотреть все", style = textStyleAccent)
    }
}

@Composable
fun DateField(title: String, date: String) {
    Row {
        Text(text = title, style = textStyleAdditional)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = date, style = textStyleAdditionalDark)
    }
}