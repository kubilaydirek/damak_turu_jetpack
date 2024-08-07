package com.kolaysoft.yemekleruygulamasi.ui.scene.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingBasket
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.kolaysoft.yemekleruygulamasi.data.model.MealModel
import com.kolaysoft.yemekleruygulamasi.ui.component.MealCard
import com.kolaysoft.yemekleruygulamasi.ui.scene.SharedViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScene(modifier: Modifier, navigateToBasketPage: () -> Unit, sharedViewModel: SharedViewModel = hiltViewModel()) {
    val viewModel: HomeViewModel = hiltViewModel()
    val mealsData by viewModel.data.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Yemekler") }, actions = {
                IconButton(onClick = { navigateToBasketPage.invoke() }) {
                    Icon(imageVector = Icons.Default.ShoppingBasket, contentDescription = "")
                }
            })
        },
        content = {
            if (mealsData?.yemekler?.isNotEmpty() == true) {
                Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

                    LazyVerticalGrid(
                        modifier = modifier,
                        columns = GridCells.Fixed(2),
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        contentPadding = PaddingValues(bottom = 30.dp, top = 10.dp, start = 5.dp),
                    ) {
                        items(mealsData!!.yemekler) { meal ->
                            MealCard(imageName = meal.yemek_resim_adi, mealName = meal.yemek_adi, buttonOnclick = {
                                sharedViewModel.addMeal(
                                    MealModel(
                                        yemek_adi = meal.yemek_adi,
                                        yemek_fiyat = meal.yemek_fiyat,
                                        yemek_id = meal.yemek_id,
                                        yemek_resim_adi = meal.yemek_resim_adi
                                    )
                                )
                            })
                        }
                    }
                }
            }
        },

        )
}