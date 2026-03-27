package com.itainformatica.models

import kotlinx.serialization.*

@Serializable
class Category(
    val id: Int = 0,
    val name: String = "",
    val imageUrl: String = "",
    @Transient
    val onTap: () -> Unit = {}
)