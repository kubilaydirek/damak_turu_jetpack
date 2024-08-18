package com.kolaysoft.yemekleruygulamasi.ui.scene.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kolaysoft.yemekleruygulamasi.data.model.FoodModel
import com.kolaysoft.yemekleruygulamasi.data.repositoryImp.AllFoodRepositoryImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: AllFoodRepositoryImp,
) : ViewModel() {
    private val _data = MutableStateFlow<FoodModel?>(null)
    val data = _data.asStateFlow()

    init {
        getAllMeals()
    }

    private fun getAllMeals() {
        viewModelScope.launch {
            val result = repository.getAllMeals()
            if (result.code() == 200) {
                result.body()?.let {
                    _data.value = result.body()!!
                }
            } else {
                // TODO: Handle error response
            }
        }
    }

    fun addFavoriteFood(food: FoodModel.Yemekler) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getItem(food.yemek_id).firstOrNull()
            if (result == null) {
                repository.addFavoriteFood(food)
            } else {
                repository.deleteFavoritesFood(food.yemek_id)
            }

        }

    }

    fun foodIsFavorite(yemekId: String): StateFlow<Boolean> {
        val isFavorite = MutableStateFlow(false)
        viewModelScope.launch(Dispatchers.IO) {
            repository.getItem(yemekId).collect { result ->
                isFavorite.value = result != null
            }
        }
        return isFavorite.asStateFlow()
    }

}