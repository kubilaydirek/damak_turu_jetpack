package com.kolaysoft.yemekleruygulamasi.ui.scene.favorites

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.kolaysoft.yemekleruygulamasi.ui.navigation.FoodNavigationEnum
import com.kolaysoft.yemekleruygulamasi.ui.scene.basket.BasketViewModel

fun NavGraphBuilder.favoritesNavigation(navController: NavController, modifier: Modifier, basketViewModel: BasketViewModel) {
    composable(FoodNavigationEnum.FAVORITE.name) {
        FavoritesScene(
            modifier = modifier,
            basketViewModel = basketViewModel,
            navigateToBasketPage = { navController.navigate(FoodNavigationEnum.BASKET.name) },
            onNavigateToHome = { navController.navigate(FoodNavigationEnum.HOME.name) },
            onNavigateToProfile = { navController.navigate(FoodNavigationEnum.PROFILE.name) },
            onNavigateToFavorite = { navController.navigate(FoodNavigationEnum.FAVORITE.name) }
        )
    }
}