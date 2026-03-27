package com.itainformatica.models

@kotlinx.serialization.Serializable
data class JsonFile(
    val categories: List<Category> = emptyList(),
    val products: List<Product> = emptyList(),
    val stores: List<Store> = emptyList()
)