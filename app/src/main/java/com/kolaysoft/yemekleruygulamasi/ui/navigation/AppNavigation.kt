package com.kolaysoft.yemekleruygulamasi.ui.navigation

import BasketScene
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kolaysoft.yemekleruygulamasi.ui.scene.SharedViewModel
import com.kolaysoft.yemekleruygulamasi.ui.scene.home.HomeScene

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val modifier = Modifier
    val sharedViewModel: SharedViewModel = hiltViewModel()
    NavHost(navController = navController, startDestination = "homePage") {
        composable("homePage") {
            HomeScene(
                modifier = modifier,
                navigateToBasketPage = { navController.navigate("basketScene") },
                sharedViewModel = sharedViewModel
            )
        }
        composable("basketScene") {
            BasketScene(modifier = modifier, sharedViewModel = sharedViewModel)
        }
    }
}