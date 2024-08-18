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
            onNavigateToHome = {
                navController.navigate(FoodNavigationEnum.HOME.name) {
                    popUpTo(FoodNavigationEnum.HOME.name) {
                        inclusive = true
                    }
                }
            },
            onNavigateToFavorites = {
                navController.navigate(FoodNavigationEnum.FAVORITE.name) {
                    popUpTo(FoodNavigationEnum.HOME.name) {
                        inclusive = true
                    }
                }
            },
            onNavigateToProfile = {
                navController.navigate(FoodNavigationEnum.PROFILE.name) {
                    popUpTo(FoodNavigationEnum.HOME.name) {
                        inclusive = true
                    }
                }
            },
            onNavigateToBasket = {
                navController.navigate(FoodNavigationEnum.BASKET.name) {
                    popUpTo(FoodNavigationEnum.HOME.name) {
                        inclusive = true
                    }
                }
            }
        )
    }
}