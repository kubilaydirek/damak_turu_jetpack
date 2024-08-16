package com.kolaysoft.yemekleruygulamasi.ui.scene.basket

import androidx.lifecycle.ViewModel
import com.kolaysoft.yemekleruygulamasi.data.model.FoodModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class BasketViewModel @Inject constructor() : ViewModel() {
    private val _meal = MutableStateFlow<List<FoodModel.Yemekler?>>(emptyList())
    val meal = _meal.asStateFlow()
    private val _totalAmount = MutableStateFlow(0)
    val totalAmount = _totalAmount.asStateFlow()
    private val _basketTotalCount = MutableStateFlow(0)
    val basketTotalCount = _basketTotalCount.asStateFlow()

    fun addMeal(foodName: String, foodId: String, foodImage: String, foodPrice: String, foodQuantity: Int) {
        val newFood = FoodModel.Yemekler(
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
        totalCount()

    }

    fun deleteBasketMeal(food: FoodModel.Yemekler) {
        _meal.update { currentList ->
            val mealList = currentList.toMutableList()
            mealList.removeAll { it?.yemek_id == food.yemek_id }
            mealList
        }
        totalAmount()
        totalCount()
    }

    fun totalAmount() {
        _totalAmount.value = 0
        for (i in _meal.value) {
            _totalAmount.value += (i?.quantity ?: 0) * (i?.yemek_fiyat?.toInt() ?: 0)
        }
    }

    private fun totalCount() {
        _basketTotalCount.value = 0
        for (i in _meal.value) {
            _basketTotalCount.value += (i?.quantity ?: 0)
        }
    }

}