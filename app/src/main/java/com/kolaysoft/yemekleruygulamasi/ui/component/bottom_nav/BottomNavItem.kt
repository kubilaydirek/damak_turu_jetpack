package com.kolaysoft.yemekleruygulamasi.ui.component.bottom_nav

import com.kolaysoft.yemekleruygulamasi.R

sealed class BottomNavItem(
    var title: String,
    var icon: Int
) {
    data object Home : BottomNavItem(title = "Anasayfa", icon = R.drawable.home_icon)
    data object Profile : BottomNavItem(title = "Profil", icon = R.drawable.profile_icon)
    data object Favorite : BottomNavItem(title = "Favoriler", icon = R.drawable.favorite)
    data object Basket : BottomNavItem(title = "Sepet", icon = R.drawable.basket_icon)

}