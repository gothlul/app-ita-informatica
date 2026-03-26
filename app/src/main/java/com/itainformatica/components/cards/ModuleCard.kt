package com.itainformatica.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.itainformatica.R


@Composable
fun ModuleCard(
    modifier: Modifier = Modifier,
    title: String = "",
    icon: Painter? = null,
    fontSize: Float = 16f,
    borderRadius: Dp = 10.dp,
    spacing: Dp = 8.dp,
    iconColor: Color = Color.Black,
    gradientColors: List<Color> = listOf(Color.Gray, Color.LightGray),
    padding: PaddingValues = PaddingValues(all = 8.dp),
    onTap: () -> Unit = {},
    isSolid: Boolean = false,
) {
    val painter = icon?: painterResource(id = R.drawable.no_icon)
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
            )
            .clickable(
                onClick = {
                    onTap()
                }
            )
            .onSizeChanged { boxSize = it }
            .background(
                brush = if (boxSize.width > 0 && boxSize.height > 0) {
                    Brush.linearGradient(
                        colors = gradientColors,
                        start = Offset(x = 0f, y = boxSize.height.toFloat()),
                        end = Offset(x = boxSize.width.toFloat(), y = 0f)
                    )
                } else {
                    Brush.linearGradient(colors = gradientColors)
                },
                shape = RoundedCornerShape(size = borderRadius)
            )
            .width(100.dp)
            .height(100.dp),
    ){
        if (!isSolid) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .offset(y = (-35).dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(bottomEnd = 50.dp, bottomStart = 50.dp)
                    )
            )
        }
        Column(
            modifier = Modifier
                .padding(paddingValues = padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                colorFilter = ColorFilter.tint(iconColor),
                modifier = Modifier
                    .height(40.dp)
            )
            Spacer(modifier = Modifier.height(spacing))
            Text(
                title,
                fontSize = fontSize.sp,
                color = iconColor
            )
        }
    }
}