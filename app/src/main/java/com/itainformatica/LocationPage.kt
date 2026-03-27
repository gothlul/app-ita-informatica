package com.itainformatica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.itainformatica.components.cards.BottomSheet
import com.itainformatica.components.pages.MainPage
import com.itainformatica.ui.theme.AppitainformaticaTheme

class LocationPage : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppitainformaticaTheme {
                MainPage(padding = PaddingValues(0.dp)) {
                    Box(modifier = Modifier.fillMaxSize()) {

                        Text("Conteúdo que fica atrás do Sheet", modifier = Modifier.fillMaxSize())

                        BottomSheet(
                            modifier = Modifier.align(Alignment.BottomCenter),
                            bottomLimit = 40f,
                            topLimit = 80f
                        ) {
                            Text("Nossas Lojas")
                        }
                    }
                }
            }
        }
    }
}