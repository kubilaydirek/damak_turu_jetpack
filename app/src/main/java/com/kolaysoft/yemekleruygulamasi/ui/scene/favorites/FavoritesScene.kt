package com.kolaysoft.yemekleruygulamasi.ui.scene.favorites

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.kolaysoft.yemekleruygulamasi.ui.component.FoodTopAppBar
import com.kolaysoft.yemekleruygulamasi.ui.component.bottom_nav.BottomNavItem
import com.kolaysoft.yemekleruygulamasi.ui.component.bottom_nav.FoodBottomNavigation
import com.kolaysoft.yemekleruygulamasi.ui.scene.basket.BasketViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FavoritesScene(
    modifier: Modifier,
    basketViewModel: BasketViewModel,
    navigateToBasketPage: () -> Unit
) {
    val basketItemCount by basketViewModel.basketTotalCount.collectAsState()

    Scaffold(
        topBar = {
            FoodTopAppBar(
                modifier = modifier,
                title = "Favorilerim",
                basketItemCount = basketItemCount.toString(),
                navigateToBasketPage = { navigateToBasketPage.invoke() })
        },
        content = { innerPadding ->
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "asdasdasd")
            }
        },
        bottomBar = {
            FoodBottomNavigation(
                onNavigateToHome = { /*TODO*/ },
                onNavigateToProfile = { /*TODO*/ },
                onNavigateToFavorite = { /*TODO*/ },
                onNavigateToBasket = { navigateToBasketPage.invoke() },
                selectedItem = BottomNavItem.Favorite
            )
        }
    )

}