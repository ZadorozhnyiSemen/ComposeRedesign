package com.compose.redesign.scooter.kit

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.foundation.*
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.material.Card
import androidx.ui.material.ripple.ripple
import androidx.ui.res.vectorResource
import androidx.ui.unit.dp
import com.compose.redesign.scooter.R
import com.compose.redesign.scooter.domain.Category
import com.compose.redesign.scooter.domain.CategoryItem
import com.compose.redesign.scooter.domain.PricedItem
import com.compose.redesign.scooter.domain.ShortCutItem
import com.compose.redesign.scooter.styles.*
import com.compose.redesign.scooter.ui.Screen
import com.compose.redesign.scooter.ui.navigateTo
import kotlin.random.Random

@Composable
fun ShortCutScroller() {
    HorizontalScroller {
        Row(Modifier.padding(top = 4.dp, bottom = 4.dp, start = 12.dp, end = 12.dp)) {
            for (item in shortCuts) {
                Spacer(modifier = Modifier.width(4.dp))
                ShortCut(item)
                Spacer(modifier = Modifier.width(4.dp))
            }
        }
    }
}

@Composable
fun ShortCut(item: ShortCutItem) {
    val icon = vectorResource(id = item.icon)
    Card(
        modifier = Modifier.width(160.dp).preferredHeight(134.dp),
        shape = RoundedCornerShape(6.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize().ripple(),
            gravity = Alignment.Center,
            paddingStart = 16.dp,
            paddingEnd = 16.dp,
            paddingTop = 20.dp,
            paddingBottom = 20.dp
        ) {
            Column {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    asset = icon,
                    contentScale = ContentScale.Inside
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = item.title,
                    style = textStyleSecondaryHeaderCenter
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = item.subtitle,
                    style = textStyleAdditionalSmallBlack
                )
            }
        }
    }
}

@Composable
fun CatalogBlock(modifier: Modifier) {
    Column(modifier = modifier) {
        categories.forEach {
            SubCatalog(it)
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun SubCatalog(category: Category) {
    Column {
        Text(text = category.title, style = textStyleSecondaryHeader)
        Spacer(modifier = Modifier.height(8.dp))
        category.items.forEach {
            CategoryDescriptor(category = it)
        }
    }
}

@Composable
fun CategoryDescriptor(category: CategoryItem) {

    Clickable(onClick = {
        println("Navigate to category ${category.title}")
        navigateTo(Screen.Category(category.id))
    }) {
        Row(
            modifier = Modifier.preferredHeight(34.dp),
            verticalGravity = Alignment.CenterVertically
        ) {

            Text(text = category.title, style = textStyleAccent)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = category.size.toString(), style = textStyleAdditional)
        }
    }
}

val shortCuts = listOf(
    ShortCutItem(0, "От Самоката", "Вкусные продукты с местных ферм", R.drawable.ic_sc_scooter),
    ShortCutItem(1, "Готовая еда", "Elementaree и не только", R.drawable.ic_sc_food),
    ShortCutItem(2, "Развлечения", "Настолки, журналы, техника", R.drawable.ic_sc_games)
)

val pricedItem = PricedItem(
    0,
    if (Random.nextBoolean()) 0.0f else -0.23f,
    100f,
    R.drawable.j7,
    "Виноград без косточек, 500 г"
)

val items1 = listOf(
    CategoryItem(0, "Овощи и зелень", 10, List(10) { pricedItem }),
    CategoryItem(1, "Овощные консервы", 1, List(1) { pricedItem }),
    CategoryItem(2, "Орехи и сухофрукты", 2, List(2) { pricedItem }),
    CategoryItem(3, "Фрукты и ягоды", 8, List(8) { pricedItem })
)

val items2 = listOf(
    CategoryItem(4, "Йогурт густой", 10, List(10) { pricedItem }),
    CategoryItem(5, "Йогурт питьевой", 1, List(1) { pricedItem }),
    CategoryItem(6, "Кефир и ряженка", 2, List(2) { pricedItem }),
    CategoryItem(7, "Молоко", 10, List(10) { pricedItem }),
    CategoryItem(8, "Молоко растительное и соевое", 1, List(1) { pricedItem }),
    CategoryItem(9, "Мороженое", 6, List(6) { pricedItem }),
    CategoryItem(10, "Сметана", 3, List(3) { pricedItem }),
    CategoryItem(11, "Сливки и сгущёнка", 3, List(3) { pricedItem }),
    CategoryItem(12, "Сливочное масло", 6, List(6) { pricedItem }),
    CategoryItem(13, "Сырки и пудинги", 5, List(5) { pricedItem }),
    CategoryItem(14, "Творог", 5, List(5) { pricedItem }),
    CategoryItem(15, "Яйца", 4, List(4) { pricedItem })
)

val items3 = listOf(
    CategoryItem(16, "Выпечка", 7, List(7) { pricedItem }),
    CategoryItem(17, "Пряники, баранки, сушки", 1, List(1) { pricedItem }),
    CategoryItem(18, "Хлеб", 8, List(8) { pricedItem }),
    CategoryItem(19, "Хлеб для сэндвичей", 3, List(3) { pricedItem }),
    CategoryItem(20, "Хлебцы", 5, List(5) { pricedItem })
)

val items4 = listOf(
    CategoryItem(21, "Выпечка", 22, List(22) { pricedItem }),
    CategoryItem(22, "Кофейные напитки", 3, List(3) { pricedItem }),
    CategoryItem(23, "Лимонады и газировки", 20, List(20) { pricedItem }),
    CategoryItem(23, "Морсы", 1, List(1) { pricedItem }),
    CategoryItem(23, "Пиво безалкогольное", 3, List(3) { pricedItem }),
    CategoryItem(23, "Соки", 18, List(18) { pricedItem }),
    CategoryItem(23, "Энергетики", 9, List(9) { pricedItem })
)

val categories = listOf(
    Category(0, "Овощи и фрукты", items1),
    Category(1, "Молочные продукты", items2),
    Category(2, "Хлеб и выпечка", items3),
    Category(3, "Напитки", items4)
)
