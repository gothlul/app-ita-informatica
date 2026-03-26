package com.itainformatica.components.buttons

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.*
import com.itainformatica.R

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun IconButton(
    modifier: Modifier = Modifier,
    icon: Painter? = null,
    onTap: () -> Unit = {},
    color: Color = Color.Black,
    iconColor: Color = Color.White,
    size: Float = 10f,
    borderRadius: Dp = 100.dp,
    background: Boolean = true,
    padding: PaddingValues = PaddingValues(all = 12.dp)
) {
    val painter = icon?: painterResource(id = R.drawable.no_icon)
    val baseSize = LocalConfiguration.current.screenWidthDp.dp * 0.01f

    Button(
        onClick = onTap,
        colors = ButtonDefaults.buttonColors(containerColor = if(background) color else Color.Transparent),
        modifier = modifier
            .width(baseSize * size)
            .height(baseSize * size),
        contentPadding = padding,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp
        ),
        shape = RoundedCornerShape(size = borderRadius)
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            colorFilter = ColorFilter.tint(iconColor),
            modifier = Modifier
                .fillMaxSize()
        )
    }
}