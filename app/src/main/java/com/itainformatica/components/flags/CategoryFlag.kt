package com.itainformatica.components.flags

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

@Composable
fun CategoryFlag(
    modifier: Modifier = Modifier,
    title: String?,
    color: Color = Color.Black,
    textColor: Color = Color.White,
    borderRadius: Dp = 6.dp,
    padding: Dp = 6.dp,
){
    Box(
        modifier = Modifier
            .background(
                color = color,
                shape = RoundedCornerShape(borderRadius),
            )
            .padding(padding),
    ){
        Text(
            text = title?:"",
            color = textColor
        )
    }
}