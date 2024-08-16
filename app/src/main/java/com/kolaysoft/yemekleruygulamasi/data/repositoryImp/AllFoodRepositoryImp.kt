package com.kolaysoft.yemekleruygulamasi.data.repositoryImp

import com.kolaysoft.yemekleruygulamasi.data.database.FoodDAO
import com.kolaysoft.yemekleruygulamasi.data.model.FoodModel
import com.kolaysoft.yemekleruygulamasi.data.repository.AllFoodRepository
import com.kolaysoft.yemekleruygulamasi.data.service.ApiService
import kotlinx.coroutines.flow.Flow
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response
import javax.inject.Inject

class AllFoodRepositoryImp @Inject constructor(private val service: ApiService, private val room: FoodDAO) :
    AllFoodRepository {


    override suspend fun getAllMeals(): Response<FoodModel> {
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

    override suspend fun addFavoriteFood(food: FoodModel.Yemekler) {
        room.insertFavoriteFood(food)
    }

    override fun getItem(id: String): Flow<FoodModel.Yemekler> {
        return room.getItem(id)
    }


}