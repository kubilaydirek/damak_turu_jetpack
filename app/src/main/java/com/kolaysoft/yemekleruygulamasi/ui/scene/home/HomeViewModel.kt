package com.kolaysoft.yemekleruygulamasi.ui.scene.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.kolaysoft.yemekleruygulamasi.data.model.AllFoodModel
import com.kolaysoft.yemekleruygulamasi.data.repositoryImp.AllFoodRepositoryImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: AllFoodRepositoryImp,
) : ViewModel() {
    private val _data = MutableStateFlow<AllFoodModel?>(null)
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

}