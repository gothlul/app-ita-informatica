package com.itainformatica.components.cards

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.itainformatica.R

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun MainCard(
    modifier: Modifier = Modifier,
    imageUrl: String? = null,
    imageRadius: RoundedCornerShape? = null,
    imageScale: Float = 35f,
    imageAlign: Alignment = Alignment.BottomEnd,
    gradientColors: List<Color> = listOf(Color.Gray, Color.LightGray),
    borderRadius: Dp = 10.dp,
    onTap: () -> Unit = {},
    height: Float = 50f,
    padding: PaddingValues = PaddingValues(top = 20.dp),
    contentPadding: PaddingValues = PaddingValues(all = 15.dp),
    content: @Composable () -> Unit = {},
) {
    val borderImage = imageRadius?:RoundedCornerShape(
        topStart = 1000.dp,
        bottomEnd = borderRadius
    )

    val baseSize = LocalConfiguration.current.screenWidthDp.dp * 0.01f

    var boxSize by remember {
        mutableStateOf(
            value = IntSize(width = 0, height = 0)
        )
    }

    Box(
        modifier = modifier
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(size = borderRadius),
                clip = false
            )
            .onSizeChanged {
                boxSize = it
            }
            .background(
                brush = if (boxSize.width > 0 && boxSize.height > 0) {
                    Brush.linearGradient(
                        colors = gradientColors,
                        start = Offset(x = boxSize.width.toFloat()/4, y = boxSize.height.toFloat()),
                        end = Offset(x = boxSize.width.toFloat(), y = 0f)
                    )
                } else {
                    Brush.linearGradient(colors = gradientColors)
                },
                shape = RoundedCornerShape(size = borderRadius)
            )
            .fillMaxWidth()
            .height(baseSize * height)
            .clickable(
                onClick = {
                    onTap()
                }
            ),
        contentAlignment = Alignment.CenterStart
    ){
        Box(
            modifier = Modifier
                .padding(paddingValues = padding)
                .clip(
                    shape = borderImage
                )
                .align(alignment = imageAlign)
        ){
            if(imageUrl == null || imageUrl == ""){
                Image(
                    painter = painterResource(id = R.drawable.no_image),
                    contentDescription = null,
                    modifier = Modifier
                        .height((baseSize * imageScale))
                )
            }else{
                AsyncImage(
                    model = imageUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .widthIn(max = baseSize * 55)
                        .height((baseSize * imageScale))
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = contentPadding)
        ) {
            content()
        }
    }
}