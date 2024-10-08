package com.example.yemekleruygulamasi.ui.scene.profile

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.yemekleruygulamasi.ui.navigation.FoodNavigationEnum

fun NavGraphBuilder.profileNavigation(navController: NavController, modifier: Modifier) {
    composable(FoodNavigationEnum.PROFILE.name) {
        ProfileScene(
            modifier = modifier,
            onNavigateToHome = {
                navController.navigate(FoodNavigationEnum.HOME.name) {
                    popUpTo(FoodNavigationEnum.PROFILE.name) {
                        inclusive = true
                    }
                }
            },
            onNavigateToProfile = {
                navController.navigate(FoodNavigationEnum.PROFILE.name) {
                    popUpTo(FoodNavigationEnum.PROFILE.name) {
                        inclusive = true
                    }
                }
            },
            onNavigateToFavorite = {
                navController.navigate(FoodNavigationEnum.FAVORITE.name) {
                    popUpTo(FoodNavigationEnum.PROFILE.name) {
                        inclusive = true
                    }
                }
            },
            onNavigateToBasket = {
                navController.navigate(FoodNavigationEnum.BASKET.name) {
                    popUpTo(FoodNavigationEnum.PROFILE.name) {
                        inclusive = true
                    }
                }
            },
        )
    }

}