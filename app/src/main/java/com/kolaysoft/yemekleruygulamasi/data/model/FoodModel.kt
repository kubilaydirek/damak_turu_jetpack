package com.kolaysoft.yemekleruygulamasi.data.model

data class FoodModel(
    val yemek_adi: String,
    val yemek_fiyat: String,
    val yemek_id: String,
    val yemek_resim_adi: String,
    var quantity: Int = 0,
)
