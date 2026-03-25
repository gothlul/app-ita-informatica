package com.itainformatica.components.navbar

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

class NavItem(
    val icon: Painter,
    val iconColor: Color = Color.Companion.Black,
    val onTap: () -> Unit
){}