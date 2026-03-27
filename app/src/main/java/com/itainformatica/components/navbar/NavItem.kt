package com.itainformatica.components.navbar

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

class NavItem(
    val icon: Painter? = null,
    val iconColor: Color = Color.Black,
    val onTap: () -> Unit = {}
)