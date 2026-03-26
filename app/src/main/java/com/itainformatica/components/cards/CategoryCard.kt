package com.itainformatica.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.itainformatica.R

@Composable
fun CategoryCard(
    modifier: Modifier = Modifier,
    title: String = "",
    image: Painter? = null,
    onTap: () -> Unit,
    borderRadius: Dp = 100.dp,
    fontSize: Float = 12f,
    imageSize: Float = 20f,
    padding: PaddingValues = PaddingValues(all = 14.dp)
) {
    val painter = image?: painterResource(id = R.drawable.no_icon)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .clickable {
                onTap()
            },
    ){
        Box(
            modifier = modifier
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(size = borderRadius),
                    clip = false
                )
                .background(Color.White, shape = RoundedCornerShape(size = borderRadius))
                .padding(paddingValues = padding),
            contentAlignment = Alignment.CenterStart
        ){
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .size(width = imageSize.dp, height = imageSize.dp)
            )
        }
        Spacer(modifier = Modifier.height((fontSize * 0.5).dp))
        Text(
            title,
            fontSize = fontSize.sp
        )
    }
}