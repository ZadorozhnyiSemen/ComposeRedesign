package com.compose.redesign.scooter.styles

import androidx.ui.graphics.Color
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.text.style.TextAlign
import androidx.ui.text.style.TextDecoration
import androidx.ui.unit.sp

fun typographyH1(
    color: Color = Color.Black,
    decoration: TextDecoration? = null
) = TextStyle(
    color = color,
    textDecoration = decoration,
    fontFamily = appFontFamily,
    fontWeight = FontWeight.W700,
    fontStyle = FontStyle.Normal,
    fontSize = 24.sp
)

fun typographyH2(
    color: Color = Color.Black,
    decoration: TextDecoration? = null,
    align: TextAlign? = null
) = TextStyle(
    color = color,
    textDecoration = decoration,
    fontFamily = appFontFamily,
    fontWeight = FontWeight.W600,
    fontStyle = FontStyle.Normal,
    fontSize = 16.sp,
    textAlign = align
)

fun typographyH3(
    color: Color = Color.Black,
    decoration: TextDecoration? = null
) = TextStyle(
    color = color,
    textDecoration = decoration,
    fontFamily = appFontFamily,
    fontWeight = FontWeight.W500,
    fontStyle = FontStyle.Normal,
    fontSize = 14.sp
)

fun typographyText(
    color: Color = Color.Black,
    decoration: TextDecoration? = null
) = TextStyle(
    color = color,
    textDecoration = decoration,
    fontFamily = appFontFamily,
    fontWeight = FontWeight.W500,
    fontStyle = FontStyle.Normal,
    fontSize = 14.sp
)

fun typographyLinks(
    color: Color = Color.Black,
    decoration: TextDecoration? = null
) = TextStyle(
    color = color,
    textDecoration = decoration,
    fontFamily = appFontFamily,
    fontWeight = FontWeight.W600,
    fontStyle = FontStyle.Normal,
    fontSize = 14.sp
)

fun typographyCaptionSemi(
    color: Color = Color.Black,
    decoration: TextDecoration? = null
) = TextStyle(
    color = color,
    textDecoration = decoration,
    fontFamily = appFontFamily,
    fontWeight = FontWeight.W600,
    fontStyle = FontStyle.Normal,
    fontSize = 12.sp
)

fun typographyCaptionMedium(
    color: Color = Color.Black,
    decoration: TextDecoration? = null
) = TextStyle(
    color = color,
    textDecoration = decoration,
    fontFamily = appFontFamily,
    fontWeight = FontWeight.W500,
    fontStyle = FontStyle.Normal,
    fontSize = 12.sp
)

fun typographyCaptionRegular(
    color: Color = Color.Black,
    decoration: TextDecoration? = null,
    align: TextAlign? = null
) = TextStyle(
    color = color,
    textDecoration = decoration,
    fontFamily = appFontFamily,
    fontWeight = FontWeight.W400,
    fontStyle = FontStyle.Normal,
    fontSize = 12.sp,
    textAlign = align
)

fun typographyCaptionNavbar(
    color: Color = Color.Black,
    decoration: TextDecoration? = null
) = TextStyle(
    color = color,
    textDecoration = decoration,
    fontFamily = appFontFamily,
    fontWeight = FontWeight.W600,
    fontStyle = FontStyle.Normal,
    fontSize = 9.sp
)
