package com.itainformatica.models

import kotlinx.serialization.Serializable

@Serializable
class Store (
    val id: Int = 0,
    val name: String = "",
    val addressNumber: Int = 0,
    val entrance: String = "",
    val neighborhood: String = "",
    val city: String = "",
    val imageUrl: String = "",
    val inventory: List<InventoryItem> = emptyList()
)