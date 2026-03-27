package com.itainformatica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.itainformatica.components.cards.CategoryCard
import com.itainformatica.components.cards.MainCard
import com.itainformatica.components.cards.ModuleCard
import com.itainformatica.components.cards.ProductCard
import com.itainformatica.components.fields.SearchField
import com.itainformatica.components.flags.CategoryFlag
import com.itainformatica.components.flags.SeparatorFlag
import com.itainformatica.components.pages.MainPage
import com.itainformatica.database.JsonData
import com.itainformatica.models.Category
import com.itainformatica.ui.theme.AppitainformaticaTheme
import com.itainformatica.ui.theme.DarkBlue
import com.itainformatica.ui.theme.LightBlue
import com.itainformatica.ui.theme.Primary
import com.itainformatica.ui.theme.Secondary
import com.itainformatica.ui.theme.SimpleBlue


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        JsonData.loadJson(context = this)
        enableEdgeToEdge()
        setContent {

            val baseSize = LocalConfiguration.current.screenWidthDp.dp * 0.01f

            AppitainformaticaTheme {
                MainPage(
                ) {
                    var searchTerm by remember { mutableStateOf("") }
                    val categoryScrollState = rememberScrollState()

                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        SearchField(
                            onSearch = { searchTerm = it },
                            color = LightBlue,
                            textColor = DarkBlue,
                            height = 9f,
                            width = 250f
                        )

                        if(!(searchTerm.isEmpty())){
                            Text(
                                text = buildAnnotatedString{
                                    append("Pesquisa: ")

                                    withStyle(style = SpanStyle(color = SimpleBlue)) {
                                        append(searchTerm)
                                    }
                                },
                                modifier = Modifier.padding(all = 16.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(baseSize * 6))
                        LazyVerticalGrid (
                            columns = GridCells.Fixed(2),
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier.fillMaxSize()
                        )
                        {
                            item(span = { GridItemSpan(maxLineSpan) }) {
                                MainCard(
                                    imageUrl = "android.resource://${LocalContext.current.packageName}/${R.drawable.home_card_image}",
                                    gradientColors = listOf(
                                        DarkBlue,
                                        Primary
                                    )
                                ){
                                    Box(
                                        modifier = Modifier.width(230.dp),
                                    ){
                                        Text(
                                            text = buildAnnotatedString{
                                                withStyle(
                                                    style = SpanStyle(
                                                        color = Color.White,
                                                        baselineShift = BaselineShift(0.4f)
                                                    )
                                                ) {
                                                    append("Mês do consumidor na ".uppercase())
                                                }

                                                withStyle(
                                                    style = SpanStyle(
                                                        color = Secondary,
                                                        fontSize = 24.sp,
                                                        fontWeight = FontWeight.Bold
                                                    )
                                                ) {
                                                    append("ita".uppercase())
                                                }
                                            },
                                            modifier = Modifier.padding(all = 16.dp)
                                        )
                                    }
                                }

                            }
                            item(span = { GridItemSpan(maxLineSpan) }) {
                                Spacer(modifier = Modifier.height(baseSize * 5))
                            }
                            item(span = { GridItemSpan(maxLineSpan) }) {
                                SeparatorFlag(
                                    title = "Categorias",
                                    color = SimpleBlue
                                )
                            }
                            item(span = { GridItemSpan(maxLineSpan) }) {
                                Spacer(modifier = Modifier.height(baseSize * 3))
                            }
                            item(span = { GridItemSpan(maxLineSpan) }) {
                                Row(
                                    modifier = Modifier
                                        .horizontalScroll(categoryScrollState),
                                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                                ){
                                    JsonData.categories.forEach{ item ->
                                        CategoryCard(
                                            imageUrl = item.imageUrl,
                                            imageSize = 35f,
                                            title = item.name,
                                            onTap = item.onTap
                                        )
                                    }
                                }
                            }
                            item(span = { GridItemSpan(maxLineSpan) }) {
                                Spacer(modifier = Modifier.height(baseSize * 5))
                            }
                            item(span = { GridItemSpan(maxLineSpan) }) {
                                SeparatorFlag(
                                    title = "Destaques",
                                    color = SimpleBlue
                                )
                            }
                            item(span = { GridItemSpan(maxLineSpan) }) {
                                Spacer(modifier = Modifier.height(baseSize * 3))
                            }
                            items(count = JsonData.products.size){ index ->
                                val item = JsonData.products[index]

                                ProductCard(
                                    itemName = item.name,
                                    price = item.price,
                                    categories = item.categories,
                                    imageUrl = item.images.firstOrNull()
                                ) {}
                            }
                        }
                    }
                }
            }
        }
    }
}

