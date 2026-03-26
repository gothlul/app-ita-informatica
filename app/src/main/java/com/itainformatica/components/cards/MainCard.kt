package com.itainformatica.components.cards

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.itainformatica.R

@Composable
fun MainCard(
    modifier: Modifier = Modifier,
    text: @Composable () -> Unit,
    image: Painter? = null,
    onTap: () -> Unit,
    hasButton: Boolean? = false,
    button: @Composable () -> Unit,
    borderRadius: Dp? = 10.dp,
) {
    val painter = image?: painterResource(id = R.drawable.no_image)
}