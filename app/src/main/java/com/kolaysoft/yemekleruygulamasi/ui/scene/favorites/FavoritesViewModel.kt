package com.kolaysoft.yemekleruygulamasi.ui.scene.favorites

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kolaysoft.yemekleruygulamasi.data.model.FoodModel
import com.kolaysoft.yemekleruygulamasi.data.repositoryImp.AllFoodRepositoryImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(private val repositoy: AllFoodRepositoryImp) : ViewModel() {
    private val _data = MutableStateFlow<List<FoodModel.Yemekler>>(emptyList())
    val data = _data.asStateFlow()

    init {
        getAllFavoriteFood()
    }

    fun getAllFavoriteFood() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repositoy.getAllFavoriteFood()
            if (result.isNotEmpty()) {
                _data.value = result
            }
        }
    }
}