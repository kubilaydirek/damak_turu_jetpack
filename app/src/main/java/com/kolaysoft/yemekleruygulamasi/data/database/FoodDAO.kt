package com.kolaysoft.yemekleruygulamasi.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.kolaysoft.yemekleruygulamasi.data.model.FoodModel
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodDAO {
    @Insert
    suspend fun insertFavoriteFood(food: FoodModel.Yemekler)

    @Query("SELECT * from food_table WHERE yemek_id = :id")
    fun getItem(id: String): Flow<FoodModel.Yemekler?>

    @Query("DELETE FROM food_table WHERE yemek_id = :id")
    suspend fun deleteFavoritesFood(id: String)

    @Query("SELECT * FROM food_table")
    suspend fun getAllFavoriteFood(): List<FoodModel.Yemekler>

}