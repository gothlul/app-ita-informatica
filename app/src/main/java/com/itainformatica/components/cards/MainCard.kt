package com.itainformatica.components.cards

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text

@Composable
fun MainCard(
    modifier: Modifier = Modifier,
    text: @Composable () -> Unit,
    image: Painter?,
    shape: Shape = RoundedCornerShape(16.dp),
    onTap: () -> Unit,
    hasButton: Boolean? = false,
    button: @Composable () -> Unit,
    borderRadius: Dp? = 10.dp,
) {

}