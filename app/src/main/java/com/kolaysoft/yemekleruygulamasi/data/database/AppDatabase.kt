package com.kolaysoft.yemekleruygulamasi.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kolaysoft.yemekleruygulamasi.data.model.FoodModel

@Database(entities = [FoodModel.Yemekler::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val foodDAO: FoodDAO
}