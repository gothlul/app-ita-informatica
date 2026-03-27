package com.itainformatica

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.itainformatica.components.buttons.MainButton
import com.itainformatica.components.cards.MainCard
import com.itainformatica.components.cards.ModuleCard
import com.itainformatica.components.pages.MainPage
import com.itainformatica.ui.theme.AppitainformaticaTheme
import com.itainformatica.ui.theme.DarkBlue
import com.itainformatica.ui.theme.Primary
import com.itainformatica.ui.theme.Secondary
import androidx.core.net.toUri

class InstitutionalPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val baseSize = LocalConfiguration.current.screenWidthDp.dp * 0.01f
            val scrollState = rememberScrollState()
            val currentContext = LocalContext.current

            AppitainformaticaTheme {
                MainPage(
                ){
                    Column(
                        modifier = Modifier.verticalScroll(scrollState)
                    ) {
                        Spacer(modifier = Modifier.height(baseSize * 8))
                        Text(
                            text = buildAnnotatedString {
                                append("Mais sobre a ")
                                withStyle(
                                    style = SpanStyle(
                                        color = Color(0xFF0F71D2),
                                        fontWeight = FontWeight.Medium
                                    )
                                ) {
                                    append("Ita informática")
                                }
                            },
                            fontWeight = FontWeight.Medium,
                            fontSize = (baseSize * 3.5f).value.sp
                        )
                        Spacer(modifier = Modifier.height(baseSize * 3))
                        Text(
                            text = "Nossa missão é conectar clientes e fornecedores de forma prática, rápida e confiável, facilitando a compra e venda de hardware.",
                            textAlign = TextAlign.Justify,
                            style = TextStyle(
                                textIndent = TextIndent(firstLine = (baseSize * 10).value.sp),
                            ),
                        )
                        Spacer(modifier = Modifier.height(baseSize * 15))
                        Text(
                            text = "O que nos motiva",
                            fontWeight = FontWeight.Medium,
                            fontSize = (baseSize * 3.5f).value.sp
                        )
                        Spacer(modifier = Modifier.height(baseSize * 3))
                        Text(
                            text = buildAnnotatedString {
                                append("Na ")

                                withStyle(
                                    style = SpanStyle(
                                        color = Color(0xF00F71D2),
                                        fontWeight = FontWeight.Medium
                                    )
                                ) {
                                    append("Ita informática")
                                }

                                append(", inovação contínua, transparência e agilidade nos processos é o que faz a diferença.")
                            },
                            textAlign = TextAlign.Justify,
                            style = TextStyle(
                                textIndent = TextIndent(firstLine = (baseSize * 10).value.sp),
                            ),
                        )
                        Spacer(modifier = Modifier.height(baseSize * 6))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            ModuleCard(
                                icon = painterResource(R.drawable.icon_innovation),
                                title = "Inovação",
                                iconColor = DarkBlue,
                                gradientColors = listOf(
                                    Primary,
                                    Secondary
                                )
                            )
                            ModuleCard(
                                icon = painterResource(R.drawable.icon_transparency),
                                title = "Transparência",
                                iconColor = DarkBlue,
                                gradientColors = listOf(
                                    Primary,
                                    Secondary
                                )
                            )
                            ModuleCard(
                                icon = painterResource(R.drawable.icon_agility),
                                title = "Agilidade",
                                iconColor = DarkBlue,
                                gradientColors = listOf(
                                    Primary,
                                    Secondary
                                )
                            )
                        }
                        Spacer(modifier = Modifier.height(baseSize * 15))
                        Text(
                            text = "Visite nosso site e torne-se parceiro",
                            fontWeight = FontWeight.Medium,
                            fontSize = (baseSize * 3.5f).value.sp
                        )
                        Spacer(modifier = Modifier.height(baseSize * 3))
                        MainCard (
                            imageUrl = "android.resource://${LocalContext.current.packageName}/${R.drawable.institucional_card_image}",
                            padding = PaddingValues(all = 0.dp),
                            imageAlign = Alignment.TopEnd,
                            imageRadius = RoundedCornerShape(
                                topEnd = 10.dp,
                                topStart = 80.dp,
                                bottomStart = 80.dp,
                                bottomEnd = 80.dp
                            ),
                            height = 50f,
                            gradientColors = listOf(
                                Primary,
                                Secondary
                            ),
                        ){
                            Column(
                                modifier = Modifier.width(230.dp),
                            ){
                                Text(
                                    text = buildAnnotatedString{
                                        withStyle(
                                            style = SpanStyle(
                                                color = DarkBlue,
                                                fontWeight = FontWeight.SemiBold,
                                                baselineShift = BaselineShift(0.4f)
                                            )
                                        ) {
                                            append("Torne-se parceiro e venda ")
                                        }

                                        withStyle(
                                            style = SpanStyle(
                                                color = Color.White,
                                                fontSize = 24.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                        ) {
                                            append("Mais!!".uppercase())
                                        }
                                    },
                                    modifier = Modifier.widthIn(max = 180.dp)
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                MainButton(
                                    text = "Saiba mais",
                                    onTap = {
                                        val intent = Intent(Intent.ACTION_VIEW,
                                            "https://www.itainformatica.com/".toUri())
                                        currentContext.startActivity(intent)
                                    },
                                    color = Color.White,
                                    textColor = Primary,
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(baseSize * 20))
                    }
                }
            }
        }
    }
}

