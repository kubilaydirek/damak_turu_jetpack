package com.kolaysoft.yemekleruygulamasi.ui.scene.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kolaysoft.yemekleruygulamasi.data.model.AllMealsModel
import com.kolaysoft.yemekleruygulamasi.data.model.MealModel
import com.kolaysoft.yemekleruygulamasi.data.repositoryImp.AllMealsRepositoryImp
import com.kolaysoft.yemekleruygulamasi.ui.scene.SharedViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: AllMealsRepositoryImp,
) : ViewModel() {
    private val _data = MutableStateFlow<AllMealsModel?>(null)
    val data = _data.asStateFlow()

    init {
        getAllMeals()
    }

    fun getAllMeals() {
        viewModelScope.launch {
            val result = repository.getAllMeals()
            if (result.code() == 200) {
                result.body()?.let {
                    _data.value = result.body()!! // yemekler listesini ayarlayın
                }
            } else {
                // TODO: Handle error response
            }
        }
    }

}