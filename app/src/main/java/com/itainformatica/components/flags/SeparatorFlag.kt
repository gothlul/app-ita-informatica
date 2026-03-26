package com.itainformatica.components.flags

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp

@Composable
fun SeparatorFlag(
    modifier: Modifier = Modifier,
    title: String = "",
    color: Color = Color.Gray,
    textColor: Color = Color.Black,
    fontSize: Float = 20f,
    fontWeight: FontWeight = FontWeight.Medium,
    lineWidth: Float = 150f,
    spacing: Dp = 5.dp
){
    Column {
        Text(
            text = title,
            color = textColor,
            fontSize = fontSize.sp,
            fontWeight = fontWeight
        )
        Spacer(modifier = Modifier.height(spacing))
        Box(
            modifier = modifier
                .background(
                    color = color,
                    shape = RoundedCornerShape(topEnd = 16.dp)
                )
                .width(lineWidth.dp)
                .height((2.5f).dp),
        )
    }
}