package com.compose.redesign.scooter.kit

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.foundation.*
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Card
import androidx.ui.res.imageResource
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.Dp
import androidx.ui.unit.dp
import com.compose.redesign.scooter.R
import com.compose.redesign.scooter.domain.PricedItem
import com.compose.redesign.scooter.domain.PromotedItem
import com.compose.redesign.scooter.styles.*

@Composable
@Preview
fun SaleScroller() {
    HorizontalScroller {
        Row(Modifier.padding(top = 4.dp, bottom = 4.dp, start = 12.dp, end = 12.dp)) {
            for (item in list) {
                Spacer(modifier = Modifier.width(4.dp))
                StoreItem(item)
                Spacer(modifier = Modifier.width(4.dp))
            }
        }
    }
}

@Composable
@Preview
fun RecommendationScroller() {
    HorizontalScroller {
        Row(modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)) {
            for (item in recommendationList) {
                Spacer(modifier = Modifier.width(8.dp))
                PromoItem(item)
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}

@Composable
fun StoreItem(
    item: PricedItem,
    showDescription: Boolean = false,
    height: Dp = 219.dp,
    elevation: Dp = 1.dp
) {
    val image = imageResource(id = item.image)
    Card(
        modifier = Modifier.width(160.dp).preferredHeight(height),
        shape = RoundedCornerShape(6.dp),
        elevation = elevation
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier.preferredHeight(130.dp).padding(top = 10.dp),
                gravity = ContentGravity.TopCenter
            ) {
                Image(
                    contentScale = ContentScale.Fit,
                    asset = image
                )
            }
            Column(modifier = Modifier.padding(top = 104.dp)) {
                Box {
                    Column(Modifier.padding(start = 16.dp, end = 16.dp)) {
                        if (item.onSale) {
                            Box(
                                shape = RoundedCornerShape(6.dp),
                                paddingTop = 4.dp,
                                paddingBottom = 4.dp,
                                paddingStart = 8.dp,
                                paddingEnd = 8.dp,
                                backgroundColor = colorAccent
                            ) {
                                Text(
                                    text = String.format("%+.0f%%", item.saleValue * 100),
                                    style = textStyleAdditionalSmallWhite
                                )
                            }
                        } else {
                            Spacer(modifier = Modifier.weight(1f))
                        }

                        Spacer(modifier = Modifier.height(8.dp))
                        Row(verticalGravity = Alignment.Bottom) {
                            val priceStyle =
                                if (item.onSale) textStyleSecondaryHeaderAccent else textStyleSecondaryHeader
                            Text(
                                text = String.format("%.0fр", item.price),
                                style = priceStyle
                            )
                            if (item.onSale) {
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = String.format("%.0fр", item.itemPrice),
                                    style = textStyleAdditionalCrossed
                                )
                            }
                        }
                        if (showDescription) {
                            Text(text = item.description, style = textStyleAdditionalDark)
                        }

                        Spacer(modifier = Modifier.height(8.dp))
                        Box(
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 12.dp)
                                .height(40.dp).preferredWidth(128.dp),
                            shape = RoundedCornerShape(6.dp),
                            border = Border(1.dp, colorAccent),
                            gravity = ContentGravity.Center
                        ) {
                            Text("В корзину", style = textStyleAccent)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PromoItem(item: PromotedItem) {
    val image = imageResource(id = item.image)
    Card(
        modifier = Modifier.preferredWidth(272.dp).preferredHeight(130.dp),
        shape = RoundedCornerShape(6.dp),
        color = item.itemColor
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                gravity = ContentGravity.BottomEnd
            ) {
                Image(asset = image, contentScale = ContentScale.Fit)
            }
            Column(
                modifier = Modifier.padding(
                    top = 12.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 12.dp
                )
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = item.title,
                    style = textStyleSecondaryHeaderCenter,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Card(
                    shape = RoundedCornerShape(6.dp),
                    color = colorWhite
                ) {
                    Text(
                        modifier = Modifier.padding(
                            bottom = 4.dp,
                            top = 4.dp,
                            start = 8.dp,
                            end = 8.dp
                        ),
                        text = item.category, style = textStyleAdditionalSmall
                    )
                }
            }
        }
    }

}

val list = listOf<PricedItem>(
    PricedItem(0, -.23f, 100f, R.drawable.akbar),
    PricedItem(1, .00f, 100f, R.drawable.j7),
    PricedItem(2, -.15f, 100f, R.drawable.akbar),
    PricedItem(3, -.50f, 100f, R.drawable.j7)
)

val colorFoc = Color(0.988f, 0.961f, 0.937f)
val colorMar = Color(242f / 255f, 243f / 255f, 248f / 255f)

val recommendationList = listOf(
    PromotedItem(0, "Фокачча с соусом песто от Rыба", "Рецепты", colorFoc, R.drawable.foccacha),
    PromotedItem(
        1,
        "Умная колонка Капсула c голосовым помощником Маруся",
        "Акции",
        colorMar,
        R.drawable.marusya
    ),
    PromotedItem(2, "Фокачча с соусом песто от Rыба", "Рецепты", colorFoc, R.drawable.foccacha),
    PromotedItem(
        3,
        "Умная колонка Капсула c голосовым помощником Маруся",
        "Акции",
        colorMar,
        R.drawable.marusya
    )
)