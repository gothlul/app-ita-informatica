package com.itainformatica

import MainButton
import MainPage
import NavBar
import NavItem
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.itainformatica.components.flags.CategoryFlag
import com.itainformatica.ui.theme.AppitainformaticaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppitainformaticaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainButton(
                        text = "Texto do botão",
                        onTap = {},
                        color = Color.Blue,
                        modifier = Modifier.padding(innerPadding)
                    )

                    MainPage() { }
                    CategoryFlag(
                        title = "categoria",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
