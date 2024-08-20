package com.example.yemekleruygulamasi.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class FoodModel(
    val success: Int,
    val yemekler: List<Yemekler>
) {
    @Entity(tableName = "food_table")
    data class Yemekler(
        val yemek_adi: String,
        val yemek_fiyat: String,
        @PrimaryKey
        val yemek_id: String,
        val yemek_resim_adi: String,
        var quantity: Int = 0,
        var isFavorite: Boolean = false,
    )
}