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
import androidx.ui.unit.dp
import com.compose.redesign.scooter.R
import com.compose.redesign.scooter.domain.PricedItem
import com.compose.redesign.scooter.domain.PromotedItem
import com.compose.redesign.scooter.screens.*

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
        Row(modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
            for (item in recommendationList) {
                Spacer(modifier = Modifier.width(8.dp))
                PromoItem(item)
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}

@Composable
fun StoreItem(item: PricedItem) {
    val image = imageResource(id = item.image)
    Card(
        modifier = Modifier.width(160.dp).preferredHeight(219.dp),
        shape = RoundedCornerShape(6.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier.preferredHeight(130.dp),
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
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(verticalGravity = Alignment.Bottom) {
                            Text(
                                text = String.format("%.0fр", item.price),
                                style = textStyleSecondaryHeaderAccent
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = String.format("%.0fр", item.itemPrice),
                                style = textStyleAdditionalCrossed
                            )
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
                    style = textStyleSecondaryHeader,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Box(
                    shape = RoundedCornerShape(6.dp),
                    paddingTop = 4.dp,
                    paddingBottom = 4.dp,
                    paddingStart = 8.dp,
                    paddingEnd = 8.dp,
                    backgroundColor = colorWhite
                ) {
                    Text(text = item.category, style = textStyleAdditionalSmall)
                }
            }
        }
    }

}

val list = listOf<PricedItem>(
    PricedItem(0, -.23f, 100f, R.drawable.akbar),
    PricedItem(1, -.07f, 100f, R.drawable.j7),
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