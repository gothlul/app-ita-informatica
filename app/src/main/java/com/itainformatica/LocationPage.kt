package com.itainformatica

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.core.net.toUri
import com.itainformatica.components.buttons.MainButton
import com.itainformatica.ui.theme.DarkBlue

@SuppressLint("ConfigurationScreenWidthHeight")

@Composable
fun LocationPage(context: Context) {
    val baseSize = LocalConfiguration.current.screenWidthDp.dp * 0.01f

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
                    val intent = Intent(
                        Intent.ACTION_VIEW,
                        "geo:-22.9971829,-46.8704619?q=Ita Informática".toUri()
                    )

                    intent.setPackage("com.google.android.apps.maps")
                    context.startActivity(intent)
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