package com.kolaysoft.yemekleruygulamasi.data.service

import com.kolaysoft.yemekleruygulamasi.data.model.AllMealsModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun getAllMeals(): Response<AllMealsModel>
}