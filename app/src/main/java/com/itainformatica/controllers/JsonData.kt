package com.itainformatica.controllers

import android.content.Context
import com.itainformatica.R
import com.itainformatica.models.Category
import com.itainformatica.models.JsonFile
import com.itainformatica.models.Product
import com.itainformatica.models.Store
import kotlinx.serialization.json.Json

object JsonData {
    var categories: List<Category> = emptyList()
        private set
    var products: List<Product> = emptyList()
        private set
    var stores: List<Store> = emptyList()
        private set

    fun loadJson(context: Context) {
        try {
            val inputStream = context.resources.openRawResource(R.raw.data)
            val jsonString = inputStream.bufferedReader().use { it.readText() }

            val jsonConfig = Json {
                ignoreUnknownKeys = true
                coerceInputValues = true
            }

            val jsonFile = jsonConfig.decodeFromString<JsonFile>(jsonString)

            categories = jsonFile.categories
            products = jsonFile.products
            stores = jsonFile.stores

        } catch (e: Exception) {
            e.printStackTrace()
            android.util.Log.e("JsonData", "Erro ao carregar JSON: ${e.message}")
        }
    }
}