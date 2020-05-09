package com.compose.redesign.scooter.kit

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.layout.*
import androidx.ui.unit.dp
import com.compose.redesign.scooter.screens.textStyleAccent
import com.compose.redesign.scooter.screens.textStyleAdditional
import com.compose.redesign.scooter.screens.textStyleAdditionalLight

@Composable
fun DateField(title: String, date: String) {
    Row {
        Text(text = title, style = textStyleAdditional)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = date, style = textStyleAdditionalLight)
    }
}

@Composable
fun DateAndAll() {
    Row(Modifier.padding(start = 16.dp, end = 16.dp)) {
        DateField(title = "Скидки", date = "1 - 7 Мая")
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Смотреть все", style = textStyleAccent)
    }
}