package com.itainformatica.models

import com.itainformatica.R

class Product (
    val id: Int = 0,
    val name: String = "",
    val price: Float = 0f,
    val images: List<Int> = emptyList(),
    val categories: List<Category> = emptyList(),
    val score: Float = 0f
)