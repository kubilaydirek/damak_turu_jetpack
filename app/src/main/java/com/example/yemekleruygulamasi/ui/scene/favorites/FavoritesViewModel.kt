package com.example.yemekleruygulamasi.ui.scene.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yemekleruygulamasi.data.model.FoodModel
import com.example.yemekleruygulamasi.data.repositoryImp.FoodRepositoryImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(private val repositoy: FoodRepositoryImp) : ViewModel() {
    private val _data = MutableStateFlow<List<FoodModel.Yemekler>>(emptyList())
    val data = _data.asStateFlow()

    init {
        getAllFavoriteFood()
    }

    private fun getAllFavoriteFood() {
        viewModelScope.launch(Dispatchers.IO) {
            repositoy.getAllFavoriteFood().collect { result ->
                _data.value = result
            }
        }
    }
}