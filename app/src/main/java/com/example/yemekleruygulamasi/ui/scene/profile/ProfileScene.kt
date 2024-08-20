package com.example.yemekleruygulamasi.ui.scene.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.yemekleruygulamasi.ui.component.bottom_nav.BottomNavItem
import com.example.yemekleruygulamasi.ui.component.bottom_nav.FoodBottomNavigation
import com.example.yemekleruygulamasi.ui.scene.profile.widget.ProfilePageTopBar
import com.kolaysoft.yemekleruygulamasi.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScene(
    modifier: Modifier,
    onNavigateToHome: () -> Unit,
    onNavigateToProfile: () -> Unit,
    onNavigateToFavorite: () -> Unit,
    onNavigateToBasket: () -> Unit
) {
    Scaffold(
        topBar = {
            ProfilePageTopBar()
        },
        content = {
            Surface(modifier = modifier.fillMaxWidth()) {
                Column(
                    modifier = modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = stringResource(R.string.profile))
                }
            }
        },
        bottomBar = {
            FoodBottomNavigation(
                onNavigateToHome = { onNavigateToHome.invoke() },
                onNavigateToProfile = { onNavigateToProfile.invoke() },
                onNavigateToFavorite = { onNavigateToFavorite.invoke() },
                onNavigateToBasket = { onNavigateToBasket.invoke() },
                selectedItem = BottomNavItem.Profile
            )
        }
    )
}