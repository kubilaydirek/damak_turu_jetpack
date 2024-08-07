package com.kolaysoft.yemekleruygulamasi.ui.scene

import androidx.lifecycle.ViewModel
import com.kolaysoft.yemekleruygulamasi.data.model.MealModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor() : ViewModel() {
    private val _meal = MutableStateFlow<List<MealModel?>>(emptyList())
    val meal = _meal.asStateFlow()

    fun addMeal(yemek: MealModel) {
        _meal.update { currentList ->
            currentList + yemek
        }
        println(meal.value)
    }

    fun getMeals(): List<MealModel?> {
        return meal.value.let {
            meal.value
        }
    }
}