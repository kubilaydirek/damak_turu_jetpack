package com.example.yemekleruygulamasi.ui.component.bottom_nav

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.yemekleruygulamasi.ui.theme.MainColor

@Composable
fun FoodBottomNavigation(
    onNavigateToHome: () -> Unit,
    onNavigateToProfile: () -> Unit,
    onNavigateToFavorite: () -> Unit,
    onNavigateToBasket: () -> Unit,
    selectedItem: BottomNavItem
) {

    val items = listOf(
        BottomNavItem.Home, BottomNavItem.Profile, BottomNavItem.Favorite, BottomNavItem.Basket
    )

    NavigationBar(
        containerColor = Color(0XFF4B57A1)
    ) {
        items.forEach { item ->
            AddItem(
                screen = item,
                onNavigateToHome = { onNavigateToHome.invoke() },
                onNavigateToProfile = { onNavigateToProfile.invoke() },
                onNavigateToFavorite = { onNavigateToFavorite.invoke() },
                onNavigateToBasket = { onNavigateToBasket.invoke() },
                selectedItem = selectedItem == item,
            )
        }

    }

}

@Composable
fun RowScope.AddItem(
    screen: BottomNavItem,
    onNavigateToHome: () -> Unit,
    onNavigateToProfile: () -> Unit,
    onNavigateToFavorite: () -> Unit,
    onNavigateToBasket: () -> Unit,
    selectedItem: Boolean
) {
    NavigationBarItem(

        selected = selectedItem,
        onClick = {
            if (!selectedItem) {
                when (screen) {
                    is BottomNavItem.Home -> onNavigateToHome.invoke()
                    is BottomNavItem.Profile -> onNavigateToProfile.invoke()
                    is BottomNavItem.Favorite -> onNavigateToFavorite.invoke()
                    is BottomNavItem.Basket -> onNavigateToBasket.invoke()
                }
            }

        },
        icon = { Icon(painter = painterResource(id = screen.icon), contentDescription = "", tint = Color.White) },
        label = { Text(text = screen.title, style = TextStyle(color = Color.White)) },
        alwaysShowLabel = selectedItem,
        colors = NavigationBarItemDefaults.colors(selectedIconColor = Color.White, indicatorColor = MainColor),
    )

}

@Preview
@Composable
fun PreviewBottomNavigation() {
    FoodBottomNavigation(
        onNavigateToHome = { },
        onNavigateToProfile = { },
        onNavigateToBasket = {},
        onNavigateToFavorite = {},
        selectedItem = BottomNavItem.Home
    )
}