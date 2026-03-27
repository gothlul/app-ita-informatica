package com.itainformatica.models

import kotlinx.serialization.*

@Serializable
class Category(
    val id: Int = 0,
    val name: String = "",
    @Transient
    val imageUrl: String = "",
    val onTap: () -> Unit = {}
)