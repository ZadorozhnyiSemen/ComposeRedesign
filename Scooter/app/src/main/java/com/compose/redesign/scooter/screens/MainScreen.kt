package com.compose.redesign.scooter.screens

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.*
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Scaffold
import androidx.ui.material.Surface
import androidx.ui.res.vectorResource
import androidx.ui.text.TextStyle
import androidx.ui.text.font.*
import androidx.ui.text.style.TextDecoration
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import com.compose.redesign.scooter.R
import com.compose.redesign.scooter.kit.DateAndAll
import com.compose.redesign.scooter.kit.RecommendationScroller
import com.compose.redesign.scooter.kit.SaleScroller
import com.compose.redesign.scooter.kit.SearchBar

@Composable
fun MainScreen() {
    Scaffold {
        Surface(modifier = Modifier.fillMaxSize(), color = colorBackground) {
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
                    Spacer(modifier = Modifier.height(12.dp))
                    RecommendationScroller()
                    Spacer(modifier = Modifier.height(32.dp))
                    DateAndAll()
                    Spacer(modifier = Modifier.height(12.dp))
                    SaleScroller()
                }
            }
        }
    }
}

val colorAccent = Color(1f, 0.275f, 0.443f)
val colorBackground = Color(0.961f, 0.961f, 0.961f)
val colorWhite = Color(1f, 1f, 1f)
val textPrimary = Color(0f, 0f, 0f)
val textSecondary = Color(0f, 0f, 0f, .5f)
val textSecondaryWithOpacity = Color(0f, 0f, 0f, .3f)
val textAccent = colorAccent

val appFontFamily = fontFamily(fonts = listOf(ResourceFont(R.font.montserrat)))

val textStyleAdditional = TextStyle(
    color = textSecondary,
    fontFamily = appFontFamily,
    fontWeight = FontWeight.W500,
    fontStyle = FontStyle.Normal
)

val textStyleAdditionalCrossed = TextStyle(
    color = textSecondary,
    fontFamily = appFontFamily,
    fontWeight = FontWeight.W500,
    fontStyle = FontStyle.Normal,
    textDecoration = TextDecoration.LineThrough
)

val textStyleAdditionalLight = TextStyle(
    color = textSecondaryWithOpacity,
    fontFamily = appFontFamily,
    fontWeight = FontWeight.W500,
    fontStyle = FontStyle.Normal
)

val textStyleAccent = TextStyle(
    color = textAccent,
    fontFamily = appFontFamily,
    fontSize = 14.sp,
    fontWeight = FontWeight.W600,
    fontStyle = FontStyle.Normal
)

val textStyleAdditionalSmall = TextStyle(
    color = textPrimary,
    fontFamily = appFontFamily,
    fontSize = 12.sp,
    fontWeight = FontWeight.W500,
    fontStyle = FontStyle.Normal
)

val textStyleAdditionalSmallWhite = TextStyle(
    color = colorWhite,
    fontFamily = appFontFamily,
    fontSize = 12.sp,
    fontWeight = FontWeight.W500,
    fontStyle = FontStyle.Normal,
    letterSpacing = 1.sp
)

val textStyleHeader = TextStyle(
    color = textPrimary,
    fontFamily = appFontFamily,
    fontSize = 24.sp,
    fontWeight = FontWeight.W700,
    fontStyle = FontStyle.Normal
)

val textStyleSecondaryHeader = TextStyle(
    color = textPrimary,
    fontFamily = appFontFamily,
    fontSize = 16.sp,
    fontWeight = FontWeight.W600,
    fontStyle = FontStyle.Normal
)

val textStyleSecondaryHeaderAccent = TextStyle(
    color = textAccent,
    fontFamily = appFontFamily,
    fontSize = 16.sp,
    fontWeight = FontWeight.W600,
    fontStyle = FontStyle.Normal
)