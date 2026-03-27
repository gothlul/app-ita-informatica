package com.itainformatica.models

import kotlinx.serialization.Serializable

@Serializable
class InventoryItem (
    val quantity: Int = 0,
    val product: Product = Product()
)