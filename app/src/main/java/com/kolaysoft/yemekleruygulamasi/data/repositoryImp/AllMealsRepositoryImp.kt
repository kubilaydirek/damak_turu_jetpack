package com.kolaysoft.yemekleruygulamasi.data.repositoryImp

import androidx.compose.runtime.collectAsState
import com.kolaysoft.yemekleruygulamasi.data.model.AllMealsModel
import com.kolaysoft.yemekleruygulamasi.data.model.MealModel
import com.kolaysoft.yemekleruygulamasi.data.repository.AllMealsRepository
import com.kolaysoft.yemekleruygulamasi.data.service.ApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response
import javax.inject.Inject

class AllMealsRepositoryImp @Inject constructor(private val service: ApiService) : AllMealsRepository {



    override suspend fun getAllMeals(): Response<AllMealsModel> {
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