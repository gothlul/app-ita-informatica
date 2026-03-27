package com.itainformatica

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.isSpecified
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import coil.compose.AsyncImage
import com.itainformatica.R
import com.itainformatica.components.buttons.IconButton
import com.itainformatica.components.buttons.MainButton
import com.itainformatica.components.flags.CategoryFlag
import com.itainformatica.components.pages.MainPage
import com.itainformatica.controllers.JsonData
import com.itainformatica.ui.theme.AppitainformaticaTheme
import com.itainformatica.ui.theme.DarkBlue
import com.itainformatica.ui.theme.Primary
import com.itainformatica.ui.theme.Secondary
import com.itainformatica.ui.theme.SimpleBlue

class ProductPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val id = intent.getIntExtra("PRODUCT_ID", -1)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            if(id == -1){
                onBackPressedDispatcher.onBackPressed()
            }

            val baseSize = LocalConfiguration.current.screenWidthDp.dp * 0.01f
            val categoryScroll = rememberScrollState()
            val currentContext = LocalContext.current

            val currentItem = JsonData.products.find { it.id == id }

            val imageUrl = currentItem?.images?.firstOrNull()
            val infoScroll = rememberScrollState()

            AppitainformaticaTheme {
                println("Item aberto: ${currentItem}")

                MainPage(
                ) {
                    Box{
                        if(imageUrl == null || imageUrl == ""){
                            Image(
                                painter = painterResource(id = R.drawable.no_image),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .height(300.dp)
                            )
                        }else{
                            AsyncImage(
                                model = imageUrl,
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .height(300.dp)
                            )
                        }
                        Column(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            IconButton(
                                icon = painterResource(R.drawable.icon_back),
                                color = DarkBlue,
                                onTap = {
                                    onBackPressedDispatcher.onBackPressed()
                                }
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Column(
                                modifier = Modifier
                                    .height(baseSize * 90)
                                    .verticalScroll(infoScroll)
                                    .padding(PaddingValues(vertical = baseSize * 5))
                            ) {
                                Row(
                                    modifier = Modifier.horizontalScroll(categoryScroll),
                                    horizontalArrangement = Arrangement.spacedBy(baseSize * 2f)
                                ){
                                    currentItem?.categories?.forEach { cat ->
                                        CategoryFlag(
                                            title = cat.name,
                                            color = DarkBlue
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(baseSize * 2))
                                Text(
                                    text = currentItem?.name?:"",
                                    fontSize = (baseSize * 5).value.sp
                                )
                                Spacer(modifier = Modifier.height(baseSize * 4))
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "★★★★☆",
                                        color = Color.Yellow
                                    )

                                    Spacer(modifier = Modifier.width(baseSize * 1))
                                    Text(
                                        text = "%.1f".format(currentItem?.score),
                                        color = Color.Gray,
                                        fontSize = (baseSize * 4).value.sp
                                    )
                                }
                                Spacer(modifier = Modifier.height(baseSize * 10))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    Text(
                                        text = "R$ ${"%.2f".format(currentItem?.price)}",
                                        color = SimpleBlue
                                    )
                                }
                                Spacer(modifier = Modifier.height(baseSize * 20))
                                Column(
                                  verticalArrangement = Arrangement.spacedBy(baseSize * 3)
                                ){
                                    JsonData.stores.forEach { item ->
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                        ) {
                                            Image(
                                                painter = painterResource(R.drawable.icon_locator),
                                                colorFilter = ColorFilter.tint(DarkBlue),
                                                contentDescription = null,
                                                modifier = Modifier.height(baseSize * 6)
                                            )
                                            Spacer(modifier = Modifier.width(baseSize * 3))
                                            Text(
                                                item.name
                                            )
                                            Spacer(modifier = Modifier.weight(1f))
                                            Row(
                                                verticalAlignment = Alignment.CenterVertically
                                            ){
                                                IconButton(
                                                    icon = painterResource(R.drawable.icon_call),
                                                    color = SimpleBlue,
                                                    onTap = {
                                                        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:11944954089"))
                                                        currentContext.startActivity(intent)
                                                    },
                                                )
    //                                            Spacer(modifier = Modifier.width(baseSize * 2))
    //                                            IconButton()
                                            }
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(baseSize * 20))
                                }

                            }
                        }
                    }
                }
            }
        }
    }
}