package com.kolaysoft.yemekleruygulamasi.ui.scene.basket

import BasketScene
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.kolaysoft.yemekleruygulamasi.ui.navigation.FoodNavigationEnum

fun NavGraphBuilder.basketNavigation(navController: NavController, modifier: Modifier, basketViewModel: BasketViewModel) {
    composable(FoodNavigationEnum.BASKET.name) {
        BasketScene(
            modifier = modifier,
            basketViewModel = basketViewModel,
            onNavigateToBasket = { navController.navigate(FoodNavigationEnum.BASKET.name) },
            onNavigateToFavorite = { navController.navigate(FoodNavigationEnum.FAVORITE.name) },
            onNavigateToProfile = { navController.navigate(FoodNavigationEnum.PROFILE.name) },
            onNavigateToHome = { navController.navigate(FoodNavigationEnum.HOME.name) },
            navigateToBack = { navController.popBackStack() }
        )
    }
}