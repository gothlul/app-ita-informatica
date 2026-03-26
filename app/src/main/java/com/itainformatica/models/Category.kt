package com.itainformatica.models

import com.itainformatica.R

class Category(
    val imageRes: Int = R.drawable.no_image,
    val title: String = "",
    val onTap: () -> Unit
)