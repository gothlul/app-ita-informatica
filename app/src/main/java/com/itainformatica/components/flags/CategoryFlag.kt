package com.itainformatica.components.flags

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
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
fun CategoryFlag(
    modifier: Modifier = Modifier,
    title: String?,
    color: Color = Color.Black,
    textColor: Color = Color.White,
    fontSize: Float = 12f,
    fontWeight: FontWeight = FontWeight.Bold,
    borderRadius: Dp = 5.dp,
    padding: PaddingValues = PaddingValues(horizontal = 6.dp, vertical = 3.dp)
){
    Box(
        modifier = modifier
            .background(
                color = color,
                shape = RoundedCornerShape(size = borderRadius),
            )
            .padding(paddingValues = padding),
    ){
        Text(
            text = title?:"",
            color = textColor,
            fontSize = fontSize.sp,
            fontWeight = fontWeight
        )
    }
}