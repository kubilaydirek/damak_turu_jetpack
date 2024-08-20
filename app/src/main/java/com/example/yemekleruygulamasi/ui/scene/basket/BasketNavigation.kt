package com.example.yemekleruygulamasi.ui.scene.basket

import BasketScene
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.yemekleruygulamasi.ui.navigation.FoodNavigationEnum

fun NavGraphBuilder.basketNavigation(navController: NavController, modifier: Modifier, basketViewModel: BasketViewModel) {
    composable(FoodNavigationEnum.BASKET.name) {
        BasketScene(
            modifier = modifier,
            basketViewModel = basketViewModel,
            onNavigateToBasket = {
                navController.navigate(FoodNavigationEnum.BASKET.name) {
                    popUpTo(FoodNavigationEnum.BASKET.name) {
                        inclusive = true
                    }
                }
            },
            onNavigateToFavorite = {
                navController.navigate(FoodNavigationEnum.FAVORITE.name) {
                    popUpTo(FoodNavigationEnum.BASKET.name) {
                        inclusive = true
                    }
                }
            },
            onNavigateToProfile = {
                navController.navigate(FoodNavigationEnum.PROFILE.name) {
                    popUpTo(FoodNavigationEnum.BASKET.name) {
                        inclusive = true
                    }
                }
            },
            onNavigateToHome = {
                navController.navigate(FoodNavigationEnum.HOME.name) {
                    popUpTo(FoodNavigationEnum.BASKET.name) {
                        inclusive = true
                    }
                }
            },
            navigateToBack = { navController.popBackStack() }
        )
    }
}