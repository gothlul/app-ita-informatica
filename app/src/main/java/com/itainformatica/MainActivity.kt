package com.itainformatica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.itainformatica.components.pages.MainPage
import com.itainformatica.controllers.*
import com.itainformatica.ui.theme.AppitainformaticaTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        JsonData.loadJson(context = this)
        enableEdgeToEdge()
        setContent {

            AppitainformaticaTheme {
                MainPage {
                    when (NavController.currentNavigatorIndex) {
                        Screen.HOME -> HomePage(this)
                        Screen.LOCATION -> LocationPage(this)
                        Screen.INSTITUTIONAL -> InstitutionalPage(this)
                    }
                }
            }
        }
    }
}

