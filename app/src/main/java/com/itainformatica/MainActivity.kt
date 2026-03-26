package com.itainformatica

import MainButton
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.itainformatica.components.buttons.IconButton
import com.itainformatica.components.cards.BottomSheet
import com.itainformatica.components.cards.CategoryCard
import com.itainformatica.components.cards.MainCard
import com.itainformatica.components.cards.ModuleCard
import com.itainformatica.components.cards.ProductCard
import com.itainformatica.components.fields.SearchField
import com.itainformatica.components.flags.SeparatorFlag
import com.itainformatica.components.pages.MainPage
import com.itainformatica.models.Category
import com.itainformatica.ui.theme.AppitainformaticaTheme
import com.itainformatica.ui.theme.DarkBlue
import com.itainformatica.ui.theme.LightBlue


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        JsonData.loadFromAssets(this)
        enableEdgeToEdge()
        setContent {
            AppitainformaticaTheme {
                MainPage(
                ) {
                    var searchTerm by remember { mutableStateOf("") }
                    val scrollState = rememberScrollState()

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
                        Text(
                            text = "Você pesquisou: $searchTerm",
                            modifier = Modifier.padding(all = 16.dp)
                        )

                        Column(
                            modifier = Modifier
                                .verticalScroll(scrollState)
                                .padding(vertical = 20.dp)
                        ) {
                            CategoryCard(
                                image = painterResource(id = R.drawable.bag),
                                imageSize = 35f,
                                title = "Categoria",
                                onTap = {}
                            )
                            MainCard(){
                                Column() { }
                                Text(
                                    "exemplo"
                                )
                            }
                            MainButton(
                                text = "botão",
                                onTap = {},
                            )
                            IconButton(

                            )
                            BottomSheet(
                            ){
                                Text("")
                            }
                            ProductCard(
                                itemName = "Espantalho vc batman: HQ 1987",
                                price = 20f,
                                categories = listOf(
                                    Category(
                                        title = "Categoria",
                                    )
                                ),
                            ){}
                            SeparatorFlag(
                                title = "Categorias"
                            )
                            ModuleCard(
                                title = "Texto",
                            )
                        }
                    }
                }
            }
        }
    }
}

