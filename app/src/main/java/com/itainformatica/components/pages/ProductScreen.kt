package com.itainformatica.paginas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.itainformatica.R
import com.itainformatica.components.buttons.MainButton
import com.itainformatica.components.flags.CategoryFlag
import com.itainformatica.components.pages.MainPage
import com.itainformatica.ui.theme.DarkBlue
import com.itainformatica.ui.theme.Primary

@Composable
fun ProductScreenContent(function: @Composable () -> Unit) {

    MainPage {

        Column {

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.esp32),
                contentDescription = null,
                modifier = Modifier.size(400.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            CategoryFlag(
                title = "Consumível",
                color = Primary
            )
            // Título do produto que vai vender
            Text(
                text = "Placa de circuito ESP 32",
                color = DarkBlue
            )

            //  Preço dele
            Text(
                text = "R$ 45,00",
                color = Color(0XFF063387)

            )

            Spacer(modifier = Modifier.height(8.dp))

            // Avaliação
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "★★★★☆",
                    color = Color.Yellow
                )

                Spacer(modifier = Modifier.width(8.dp))
            // deixando o "1,2k" de outra cor, nn sei se tinha uma forma mais facil
                Text(
                    text = "1,2K",
                    color = Color.Gray
                )
            }




            // Lojas
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Loja 1 - 350m")

                Row {
                    MainButton(text = "Ligar", onTap = { })
                    Spacer(modifier = Modifier.width(8.dp))
                    MainButton(text = "Whats", onTap = { })
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Loja 2 - 600m")

                Row {
                    MainButton(text = "Ligar", onTap = { })
                    Spacer(modifier = Modifier.width(8.dp))
                    MainButton(text = "Whats", onTap = { })
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Loja 3 - 1,5km")

                Row {
                    MainButton(text = "Ligar", onTap = { })
                    Spacer(modifier = Modifier.width(8.dp))
                    MainButton(text = "Whats", onTap = { })
                }
            }
        }
    }
}