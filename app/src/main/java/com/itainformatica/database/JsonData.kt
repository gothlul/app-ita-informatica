package com.itainformatica.database

import android.content.Context
import com.itainformatica.models.Category
import com.itainformatica.models.JsonFile
import com.itainformatica.models.Product
import com.itainformatica.models.Store
import kotlinx.serialization.json.Json
import java.io.IOException

object JsonData {
    var categories: List<Category> = emptyList()
        private set
    var products: List<Product> = emptyList()
        private set
    var stores: List<Store> = emptyList()
        private set


    fun loadJson(context: Context, fileName: String = "data.json") {
        try {
            val inputStream = context.assets.open(fileName)
            val size = inputStream.available()
            val buffer = ByteArray(size)

            inputStream.read(buffer)
            inputStream.close()

            val jsonString = String(buffer)
            val json = Json.decodeFromString<JsonFile>(jsonString)

            categories = json.categories
            products = json.products
            stores = json.stores

        } catch (e: IOException) {
            e.printStackTrace()
            categories = emptyList()
            products = emptyList()
            stores = emptyList()
        }
    }
}