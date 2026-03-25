package com.itainformatica.models

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

class Category(
    val image: Painter,
    val title: String = "",
    val onTap: () -> Unit
){}