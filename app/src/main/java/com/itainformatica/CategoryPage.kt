package com.itainformatica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.itainformatica.components.buttons.IconButton
import com.itainformatica.components.cards.ProductCard
import com.itainformatica.components.pages.MainPage
import com.itainformatica.controllers.JsonData
import com.itainformatica.ui.theme.AppitainformaticaTheme
import com.itainformatica.ui.theme.DarkBlue

class CategoryPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val categoryName = intent.getStringExtra("CATEGORY_NAME") ?: "Error"

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val baseSize = LocalConfiguration.current.screenWidthDp.dp * 0.01f
            val listItems = JsonData.products.filter { product ->
                val category = product.categories.firstOrNull()

                category?.name?.contains(categoryName) ?: false
            }

            AppitainformaticaTheme {
                MainPage(
                ){
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(baseSize * 5f),
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        IconButton(
                            icon = painterResource(R.drawable.icon_back),
                            color = DarkBlue,
                            onTap = {
                                onBackPressedDispatcher.onBackPressed()
                            }
                        )
                        Text(
                            text = categoryName,
                            fontSize = 24.sp
                        )
                    }
                    LazyVerticalGrid (
                        columns = GridCells.Fixed(2),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxSize()
                    ){
                        item(span = { GridItemSpan(maxLineSpan) }) {
                            Spacer(modifier = Modifier.height(baseSize * 5))
                        }

                        items(count = listItems.size){index ->
                            val item = listItems[index]

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