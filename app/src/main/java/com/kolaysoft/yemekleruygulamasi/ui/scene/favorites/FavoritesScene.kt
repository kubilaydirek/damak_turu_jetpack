package com.kolaysoft.yemekleruygulamasi.ui.scene.favorites

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import com.kolaysoft.yemekleruygulamasi.ui.scene.home.HomeViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FavoritesScene(
    modifier: Modifier,
    basketViewModel: BasketViewModel,
    navigateToBasketPage: () -> Unit,
    onNavigateToHome: () -> Unit,
    onNavigateToProfile: () -> Unit,
    onNavigateToFavorite: () -> Unit
) {
    val basketItemCount by basketViewModel.basketTotalCount.collectAsState()
    val favoritesViewModel: FavoritesViewModel = hiltViewModel()
    val favoritesList by favoritesViewModel.data.collectAsState()
    val homeViewModel: HomeViewModel = hiltViewModel()

    Scaffold(
        topBar = {
            FoodTopAppBar(
                modifier = modifier,
                title = stringResource(R.string.favorilerim),
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
                if (favoritesList.isEmpty()) {
                    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(text = stringResource(R.string.favori_listeniz_bos))
                    }
                } else {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                    ) {
                        items(favoritesList) { item ->
                            FoodCard(
                                foodPrice = item.yemek_fiyat.toInt(),
                                imageName = item.yemek_resim_adi,
                                foodName = item.yemek_adi,
                                addButtonOnClick = {
                                    basketViewModel.addFoodToDB(
                                        foodPrice = item.yemek_fiyat,
                                        foodId = item.yemek_id,
                                        foodImage = item.yemek_resim_adi,
                                        foodName = item.yemek_adi,
                                        foodQuantity = item.quantity + 1
                                    )
                                },
                                likedButtonOnClick = { homeViewModel.addFavoriteFood(item) },
                                isFavorite = true
                            )
                        }
                    }
                }

            }
        },
        bottomBar = {
            FoodBottomNavigation(
                onNavigateToHome = { onNavigateToHome.invoke() },
                onNavigateToProfile = { onNavigateToProfile.invoke() },
                onNavigateToFavorite = { onNavigateToFavorite.invoke() },
                onNavigateToBasket = { navigateToBasketPage.invoke() },
                selectedItem = BottomNavItem.Favorite
            )
        }
    )

}