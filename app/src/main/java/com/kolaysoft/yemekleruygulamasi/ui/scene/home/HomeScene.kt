package com.kolaysoft.yemekleruygulamasi.ui.scene.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.kolaysoft.yemekleruygulamasi.R
import com.kolaysoft.yemekleruygulamasi.ui.component.FoodCard
import com.kolaysoft.yemekleruygulamasi.ui.component.FoodTopAppBar
import com.kolaysoft.yemekleruygulamasi.ui.component.bottom_nav.BottomNavItem
import com.kolaysoft.yemekleruygulamasi.ui.component.bottom_nav.FoodBottomNavigation
import com.kolaysoft.yemekleruygulamasi.ui.scene.basket.BasketViewModel

@Composable
fun HomeScene(
    modifier: Modifier,
    basketViewModel: BasketViewModel,
    onNavigateToHome: () -> Unit,
    onNavigateToFavorites: () -> Unit,
    onNavigateToProfile: () -> Unit,
    onNavigateToBasket: () -> Unit,
) {
    val viewModel: HomeViewModel = hiltViewModel()
    val foodData by viewModel.data.collectAsState()
    val basketTotalCount by basketViewModel.basketTotalCount.collectAsState()
    
    Scaffold(
        topBar = {
            FoodTopAppBar(modifier = modifier,
                title = stringResource(id = R.string.damak_turu),
                basketItemCount = basketTotalCount.toString(),
                navigateToBasketPage = { onNavigateToBasket.invoke() })
        },
        content = { innerPadding ->
            Surface(modifier = modifier.padding(innerPadding)) {
                Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    if (foodData?.yemekler?.isNotEmpty() == true) {
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                        ) {
                            items(foodData!!.yemekler) { item ->
                                val isFavorite by viewModel.foodIsFavorite(item.yemek_id).collectAsState(initial = false)

                                FoodCard(
                                    imageName = item.yemek_resim_adi,
                                    foodName = item.yemek_adi,
                                    modifier = modifier,
                                    foodPrice = item.yemek_fiyat.toInt(),
                                    addButtonOnClick = {
                                        basketViewModel.addFoodToDB(
                                            foodPrice = item.yemek_fiyat,
                                            foodId = item.yemek_id,
                                            foodImage = item.yemek_resim_adi,
                                            foodName = item.yemek_adi,
                                            foodQuantity = item.quantity + 1
                                        )
                                    },
                                    likedButtonOnClick = { viewModel.addFavoriteFood(item) },
                                    isFavorite = isFavorite
                                )
                            }
                        }
                    }

                }
            }

        },
        bottomBar = {
            FoodBottomNavigation(
                onNavigateToHome = { onNavigateToHome.invoke() },
                onNavigateToProfile = { onNavigateToProfile.invoke() },
                onNavigateToFavorite = { onNavigateToFavorites.invoke() },
                onNavigateToBasket = { onNavigateToBasket.invoke() },
                selectedItem = BottomNavItem.Home
            )
        },
    )
}