package com.kolaysoft.yemekleruygulamasi.ui.scene.home

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.kolaysoft.yemekleruygulamasi.ui.navigation.FoodNavigationEnum
import com.kolaysoft.yemekleruygulamasi.ui.scene.basket.BasketViewModel

fun NavGraphBuilder.homeNavigation(navController: NavController, modifier: Modifier, basketViewModel: BasketViewModel) {
    composable(FoodNavigationEnum.HOME.name) {
        HomeScene(
            modifier = modifier,
            basketViewModel = basketViewModel,
            onNavigateToHome = { navController.navigate(FoodNavigationEnum.HOME.name) },
            onNavigateToFavorites = { navController.navigate(FoodNavigationEnum.FAVORITE.name) },
            onNavigateToProfile = { navController.navigate(FoodNavigationEnum.PROFILE.name) },
            onNavigateToBasket = { navController.navigate(FoodNavigationEnum.BASKET.name) }
        )
    }
}