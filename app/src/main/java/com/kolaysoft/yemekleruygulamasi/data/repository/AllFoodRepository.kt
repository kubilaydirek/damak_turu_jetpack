package com.kolaysoft.yemekleruygulamasi.data.repository

import com.kolaysoft.yemekleruygulamasi.data.model.AllFoodModel
import retrofit2.Response

interface AllFoodRepository {
    suspend fun getAllMeals(): Response<AllFoodModel>
}