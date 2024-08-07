package com.kolaysoft.yemekleruygulamasi.ui.scene.basket

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import com.kolaysoft.yemekleruygulamasi.data.model.MealModel
import com.kolaysoft.yemekleruygulamasi.data.repositoryImp.AllMealsRepositoryImp
import com.kolaysoft.yemekleruygulamasi.ui.scene.SharedViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class BasketViewModel @Inject constructor(
    private val repository: AllMealsRepositoryImp,
) : ViewModel() {
    private val _allBasketMeal = MutableStateFlow<List<MealModel?>>(emptyList())
    val allBasketMeal = _allBasketMeal.asStateFlow()




}