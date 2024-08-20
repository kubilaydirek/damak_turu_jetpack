package com.example.yemekleruygulamasi.ui.scene.favorites

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.yemekleruygulamasi.ui.navigation.FoodNavigationEnum
import com.example.yemekleruygulamasi.ui.scene.basket.BasketViewModel

fun NavGraphBuilder.favoritesNavigation(navController: NavController, modifier: Modifier, basketViewModel: BasketViewModel) {
    composable(FoodNavigationEnum.FAVORITE.name) {
        FavoritesScene(
            modifier = modifier,
            basketViewModel = basketViewModel,
            navigateToBasketPage = {
                navController.navigate(FoodNavigationEnum.BASKET.name) {
                    popUpTo(FoodNavigationEnum.FAVORITE.name) {
                        inclusive = true
                    }
                }
            },
            onNavigateToHome = {
                navController.navigate(FoodNavigationEnum.HOME.name) {
                    popUpTo(FoodNavigationEnum.FAVORITE.name) {
                        inclusive = true
                    }
                }
            },
            onNavigateToProfile = {
                navController.navigate(FoodNavigationEnum.PROFILE.name) {
                    popUpTo(FoodNavigationEnum.FAVORITE.name) {
                        inclusive = true
                    }
                }
            },
            onNavigateToFavorite = {
                navController.navigate(FoodNavigationEnum.FAVORITE.name) {
                    popUpTo(FoodNavigationEnum.FAVORITE.name) {
                        inclusive = true
                    }
                }
            }
        )
    }
}