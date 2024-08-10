package com.kolaysoft.yemekleruygulamasi.data.repositoryImp

import com.kolaysoft.yemekleruygulamasi.data.model.AllFoodModel
import com.kolaysoft.yemekleruygulamasi.data.repository.AllFoodRepository
import com.kolaysoft.yemekleruygulamasi.data.service.ApiService
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response
import javax.inject.Inject

class AllFoodRepositoryImp @Inject constructor(private val service: ApiService) : AllFoodRepository {


    override suspend fun getAllMeals(): Response<AllFoodModel> {
        return try {
            val result = service.getAllMeals()
            if (result.code() == 200) {
                result
            } else {
                val errorBody = result.errorBody()?.string()
                Response.error(result.code(), (errorBody ?: "Beklenmedik bir hata oluştu").toResponseBody(null))
            }
        } catch (e: Exception) {
            Response.error(500, e.message.toString().toResponseBody(null))
        }
    }


}