package com.itainformatica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.itainformatica.components.*
import com.itainformatica.components.cards.CategoryCard
import com.itainformatica.components.fields.SearchField
import com.itainformatica.components.flags.CategoryFlag
import com.itainformatica.components.pages.MainPage
import com.itainformatica.ui.theme.AppitainformaticaTheme
import com.itainformatica.ui.theme.DarkBlue
import com.itainformatica.ui.theme.LightBlue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppitainformaticaTheme {
                MainPage(
                ) {
                    var query by remember { mutableStateOf("") }

                    Column() {
                        SearchField(
                            onSearch = { query = it },
                            color = LightBlue,
                            textColor = DarkBlue,
                            height = 40f,
                            width = 250f
                        )
                        Text(
                            text = "Você pesquisou: $query",
                            modifier = Modifier.padding(16.dp)
                        )
                        CategoryCard(
                            image = painterResource(id = R.drawable.bag),
                            imageSize = 35f,
                            title = "Categoria",
                            onTap = {}
                        )
                    }
                }
            }
        }
    }
}
