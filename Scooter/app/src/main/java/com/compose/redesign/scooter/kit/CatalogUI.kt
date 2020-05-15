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
import com.compose.redesign.scooter.domain.ShortCutItem
import com.compose.redesign.scooter.styles.*
import com.compose.redesign.scooter.ui.Screen
import com.compose.redesign.scooter.ui.navigateTo

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
        Spacer(modifier = Modifier.height(16.dp))
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

val items1 = listOf(
    CategoryItem(0, "Овощи и зелень", 10),
    CategoryItem(1, "Овощные консервы", 1),
    CategoryItem(2, "Орехи и сухофрукты", 2),
    CategoryItem(3, "Фрукты и ягоды", 8)
)

val items2 = listOf(
    CategoryItem(4, "Йогурт густой", 10),
    CategoryItem(5, "Йогурт питьевой", 1),
    CategoryItem(6, "Кефир и ряженка", 2),
    CategoryItem(7, "Молоко", 10),
    CategoryItem(8, "Молоко растительное и соевое", 1),
    CategoryItem(9, "Мороженое", 6),
    CategoryItem(10, "Сметана", 3),
    CategoryItem(11, "Сливки и сгущёнка", 3),
    CategoryItem(12, "Сливочное масло", 6),
    CategoryItem(13, "Сырки и пудинги", 5),
    CategoryItem(14, "Творог", 5),
    CategoryItem(15, "Яйца", 4)
)

val items3 = listOf(
    CategoryItem(16, "Выпечка", 7),
    CategoryItem(17, "Пряники, баранки, сушки", 1),
    CategoryItem(18, "Хлеб", 8),
    CategoryItem(19, "Хлеб для сэндвичей", 3),
    CategoryItem(20, "Хлебцы", 5)
)

val items4 = listOf(
    CategoryItem(21, "Выпечка", 22),
    CategoryItem(22, "Кофейные напитки", 3),
    CategoryItem(23, "Лимонады и газировки", 20),
    CategoryItem(23, "Морсы", 1),
    CategoryItem(23, "Пиво безалкогольное", 3),
    CategoryItem(23, "Соки", 18),
    CategoryItem(23, "Энергетики", 9)
)

val categories = listOf(
    Category(0, "Овощи и фрукты", items1),
    Category(1, "Молочные продукты", items2),
    Category(2, "Хлеб и выпечка", items3),
    Category(3, "Напитки", items4)
)