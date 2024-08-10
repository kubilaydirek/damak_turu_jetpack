package com.kolaysoft.yemekleruygulamasi.ui.scene.basket

import androidx.lifecycle.ViewModel
import com.kolaysoft.yemekleruygulamasi.data.model.FoodModel
import com.kolaysoft.yemekleruygulamasi.data.repositoryImp.AllFoodRepositoryImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class BasketViewModel @Inject constructor() : ViewModel() {
    private val _meal = MutableStateFlow<List<FoodModel?>>(emptyList())
    val meal = _meal.asStateFlow()

    fun addMeal(foodName: String, foodId: String, foodImage: String, foodPrice: String, foodQuantity: Int) {
        val newFood = FoodModel(
            yemek_adi = foodName,
            yemek_id = foodId,
            yemek_resim_adi = foodImage,
            yemek_fiyat = foodPrice,
            quantity = foodQuantity
        )
        _meal.update { currentList ->
            val updatedList = currentList.toMutableList()
            var itemFound = false
            for (item in updatedList) {
                if (newFood.yemek_id == item!!.yemek_id) {
                    item.quantity += 1
                    itemFound = true
                    break
                }
            }
            if (!itemFound) {
                updatedList.add(newFood)
            }
            updatedList
        }
    }

    fun getMeals(): List<FoodModel?> {
        return meal.value.let {
            meal.value
        }
    }

    fun deleteBasketMeal(yemek: FoodModel) {
        _meal.update { item ->
            item - yemek
        }
    }

}