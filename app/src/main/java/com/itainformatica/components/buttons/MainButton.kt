package com.itainformatica.components.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*

@Composable
fun MainButton(
    modifier: Modifier = Modifier,
    text: String = "",
    onTap: () -> Unit,
    color: Color = Color.Black,
    textColor: Color = Color.White,
    fontSize: TextUnit = 16.sp,
    borderRadius: Dp = 8.dp,
    padding: PaddingValues = PaddingValues(horizontal = 32.dp, vertical = 16.dp)
) {
    Button(
        onClick = onTap,
        colors = ButtonDefaults.buttonColors(containerColor = color),
        modifier = modifier,
        contentPadding = padding,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp
        ),
        shape = RoundedCornerShape(size = borderRadius)
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = fontSize
        )
    }
}