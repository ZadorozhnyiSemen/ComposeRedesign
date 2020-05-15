package com.compose.redesign.scooter.styles

import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.text.style.TextDecoration
import androidx.ui.unit.sp

val textStyleAdditional = TextStyle(
    color = textSecondary_5,
    fontFamily = appFontFamily,
    fontWeight = FontWeight.W500,
    fontStyle = FontStyle.Normal
)

val textStyleAdditionalCrossed = TextStyle(
    color = textSecondary_5,
    fontFamily = appFontFamily,
    fontWeight = FontWeight.W500,
    fontStyle = FontStyle.Normal,
    textDecoration = TextDecoration.LineThrough
)

val textStyleAdditionalDark = TextStyle(
    color = textSecondary_9,
    fontFamily = appFontFamily,
    fontWeight = FontWeight.W500,
    fontStyle = FontStyle.Normal
)

val textStyleAdditionalLight = TextStyle(
    color = textSecondary_3,
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