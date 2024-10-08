package com.example.yemekleruygulamasi.ui.scene.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yemekleruygulamasi.data.model.FoodModel
import com.example.yemekleruygulamasi.data.repositoryImp.FoodRepositoryImp
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
    private val repository: FoodRepositoryImp,
) : ViewModel() {
    private val _data = MutableStateFlow<FoodModel?>(null)
    val data = _data.asStateFlow()

    init {
        getAllFoods()
    }

    private fun getAllFoods() {
        viewModelScope.launch {
            val result = repository.getAllFoods()
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