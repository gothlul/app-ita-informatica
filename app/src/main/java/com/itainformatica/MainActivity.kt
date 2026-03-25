package com.itainformatica

import MainPage
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import com.itainformatica.ui.theme.AppitainformaticaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppitainformaticaTheme {
                MainPage(
                ){
                    Column() {
                    }
                }
            }
        }
    }
}
