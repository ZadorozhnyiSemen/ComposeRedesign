package com.compose.redesign.scooter.screens

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.*
import androidx.ui.material.Scaffold
import androidx.ui.material.Surface
import androidx.ui.res.vectorResource
import androidx.ui.unit.dp
import com.compose.redesign.scooter.R
import com.compose.redesign.scooter.kit.DateAndAll
import com.compose.redesign.scooter.kit.RecommendationScroller
import com.compose.redesign.scooter.kit.SaleScroller
import com.compose.redesign.scooter.kit.SearchBar
import com.compose.redesign.scooter.styles.textStyleAdditional
import com.compose.redesign.scooter.styles.textStyleHeader

@Composable
fun MainScreen() {
    Scaffold {
        Surface(modifier = Modifier.fillMaxSize()) {
            VerticalScroller {
                Column {
                    Box(
                        Modifier.wrapContentWidth(Alignment.CenterHorizontally).height(44.dp),
                        paddingStart = 16.dp,
                        paddingEnd = 16.dp,
                        paddingTop = 12.dp,
                        paddingBottom = 12.dp
                    ) {
                        Row {
                            val dropdownIcon = vectorResource(id = R.drawable.ic_drop_down)
                            Text(text = "Невский проспект, 3 / 1", style = textStyleAdditional)
                            Spacer(modifier = Modifier.width(8.dp))
                            Image(modifier = Modifier.size(24.dp), asset = dropdownIcon)
                        }
                    }
                    Box(
                        Modifier.wrapContentSize(Alignment.Center),
                        paddingStart = 16.dp
                    ) {
                        Text(text = "Каталог", style = textStyleHeader)
                    }
                    SearchBar()
                    Box(
                        Modifier.wrapContentSize(Alignment.Center),
                        paddingStart = 16.dp, paddingTop = 32.dp
                    ) {
                        Text(text = "Рекомендации", style = textStyleAdditional)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    RecommendationScroller()
                    Spacer(modifier = Modifier.height(32.dp))
                    DateAndAll()
                    Spacer(modifier = Modifier.height(8.dp))
                    SaleScroller()
                }
            }
        }
    }
}
