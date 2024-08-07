package com.kolaysoft.yemekleruygulamasi.data.repository

import com.kolaysoft.yemekleruygulamasi.data.model.AllMealsModel
import retrofit2.Response

interface AllMealsRepository {
    suspend fun getAllMeals(): Response<AllMealsModel>
}