package com.kolaysoft.yemekleruygulamasi.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.kolaysoft.yemekleruygulamasi.data.model.FoodModel
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodDAO {
    @Insert
    suspend fun insertFavoriteFood(food: FoodModel.Yemekler)

    @Query("SELECT * from food_table WHERE yemek_id = :id")
    fun getItem(id: String): Flow<FoodModel.Yemekler>

}