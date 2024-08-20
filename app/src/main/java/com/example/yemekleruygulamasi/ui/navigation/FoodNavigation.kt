package com.example.yemekleruygulamasi.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.yemekleruygulamasi.ui.scene.basket.BasketViewModel
import com.example.yemekleruygulamasi.ui.scene.basket.basketNavigation
import com.example.yemekleruygulamasi.ui.scene.favorites.favoritesNavigation
import com.example.yemekleruygulamasi.ui.scene.home.homeNavigation
import com.example.yemekleruygulamasi.ui.scene.profile.profileNavigation

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val modifier = Modifier
    val basketViewModel: BasketViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = FoodNavigationEnum.HOME.name) {
        homeNavigation(navController = navController, modifier = modifier, basketViewModel = basketViewModel)
        basketNavigation(navController = navController, basketViewModel = basketViewModel, modifier = modifier)
        favoritesNavigation(navController = navController, modifier = modifier, basketViewModel = basketViewModel)
        profileNavigation(modifier = modifier, navController = navController)
    }
}