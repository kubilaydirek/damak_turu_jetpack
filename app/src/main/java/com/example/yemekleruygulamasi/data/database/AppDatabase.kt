package com.example.yemekleruygulamasi.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.yemekleruygulamasi.data.model.FoodModel

@Database(entities = [FoodModel.Yemekler::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val foodDAO: FoodDAO
}