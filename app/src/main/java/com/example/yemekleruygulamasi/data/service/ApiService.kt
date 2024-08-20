package com.example.yemekleruygulamasi.data.service

import com.example.yemekleruygulamasi.data.model.FoodModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun getAllFoods(): Response<FoodModel>

}