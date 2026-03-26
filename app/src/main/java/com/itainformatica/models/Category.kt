package com.itainformatica.models

import com.itainformatica.R

class Category(
    val image: Int = R.drawable.no_icon,
    val title: String = "",
    val onTap: () -> Unit = {}
)