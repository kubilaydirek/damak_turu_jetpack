package com.kolaysoft.yemekleruygulamasi.data.repository

import com.kolaysoft.yemekleruygulamasi.data.model.FoodModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface AllFoodRepository {
    suspend fun getAllMeals(): Response<FoodModel>

    suspend fun addFavoriteFood(food: FoodModel.Yemekler)

    fun getItem(id: String): Flow<FoodModel.Yemekler>
}