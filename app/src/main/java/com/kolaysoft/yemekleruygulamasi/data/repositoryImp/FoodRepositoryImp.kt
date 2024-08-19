package com.kolaysoft.yemekleruygulamasi.data.repositoryImp

import com.kolaysoft.yemekleruygulamasi.data.database.FoodDAO
import com.kolaysoft.yemekleruygulamasi.data.model.FoodModel
import com.kolaysoft.yemekleruygulamasi.data.repository.FoodRepository
import com.kolaysoft.yemekleruygulamasi.data.service.ApiService
import kotlinx.coroutines.flow.Flow
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response
import javax.inject.Inject

class FoodRepositoryImp @Inject constructor(private val service: ApiService, private val room: FoodDAO) :
    FoodRepository {


    override suspend fun getAllFoods(): Response<FoodModel> {
        return try {
            val result = service.getAllFoods()
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

    override fun getItem(id: String): Flow<FoodModel.Yemekler?> {
        return room.getFoodItem(id)
    }

    override suspend fun deleteFavoritesFood(yemek_id: String) {
        room.deleteFavoritesFood(yemek_id)
    }

    override suspend fun getAllFavoriteFood(): Flow<List<FoodModel.Yemekler>> {
        return room.getAllFavoriteFood()
    }


}