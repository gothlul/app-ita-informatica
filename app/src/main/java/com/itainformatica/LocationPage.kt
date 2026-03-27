package com.itainformatica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
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
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.itainformatica.components.buttons.MainButton
import com.itainformatica.ui.theme.DarkBlue

class LocationPage : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val baseSize = LocalConfiguration.current.screenWidthDp.dp * 0.01f

            AppitainformaticaTheme {
                MainPage(padding = PaddingValues(0.dp)) {
                    Box(modifier = Modifier.fillMaxSize()) {

                        val context = LocalContext.current

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {

                            Image(
                                painter = painterResource(id = R.drawable.lojas),
                                contentDescription = "lojas",
                            )
                            Spacer(modifier = Modifier.height(baseSize * 5))
                            MainButton(
                                text = "Abrir o mapa",
                                color = DarkBlue,
                                onTap = {
                                    val gmmIntentUri = Uri.parse("geo:-22.9971829,-46.8704619?q=Ita Informática")
                                    val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                                    mapIntent.setPackage("com.google.android.apps.maps")
                                    context.startActivity(mapIntent)
                                }
                            )

                        }

//                        BottomSheet(
//                            modifier = Modifier.align(Alignment.BottomCenter),
//                            bottomLimit = 40f,
//                            topLimit = 80f
//                        ) {
//                            Text("Nossas Lojas")
//                        }
                    }
                }
            }
        }
    }
}