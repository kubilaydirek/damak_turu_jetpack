package com.kolaysoft.yemekleruygulamasi.ui.scene.basket

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import com.kolaysoft.yemekleruygulamasi.data.model.AllFoodModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class BasketViewModel @Inject constructor() : ViewModel() {
    private val _meal = MutableStateFlow<List<AllFoodModel.Yemekler?>>(emptyList())
    val meal = _meal.asStateFlow()
    private val _totalAmount = MutableStateFlow<Int>(0)
    val totalAmount = _totalAmount.asStateFlow()

    fun addMeal(foodName: String, foodId: String, foodImage: String, foodPrice: String, foodQuantity: Int) {
        val newFood = AllFoodModel.Yemekler(
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

    fun getMeals(): List<AllFoodModel.Yemekler?> {
        return meal.value.let {
            meal.value
        }
    }

    fun deleteBasketMeal(yemek: AllFoodModel.Yemekler) {
        _meal.update { item ->
            item - yemek
        }
    }

    fun totalAmount() {
        for (i in _meal.value) {
            _totalAmount.value = (_totalAmount.value + (i?.quantity)!! * (i.yemek_fiyat.toInt()))
        }
    }

}