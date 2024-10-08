package com.example.yemekleruygulamasi.data.repository

import com.example.yemekleruygulamasi.data.model.FoodModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface FoodRepository {
    suspend fun getAllFoods(): Response<FoodModel>

    suspend fun addFavoriteFood(food: FoodModel.Yemekler)

    fun getItem(id: String): Flow<FoodModel.Yemekler?>

    suspend fun deleteFavoritesFood(yemek_id: String)

    suspend fun getAllFavoriteFood(): Flow<List<FoodModel.Yemekler>>
}