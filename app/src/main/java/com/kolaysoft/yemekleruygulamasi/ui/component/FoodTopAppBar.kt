package com.kolaysoft.yemekleruygulamasi.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingBasket
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kolaysoft.yemekleruygulamasi.R
import com.kolaysoft.yemekleruygulamasi.ui.theme.MainColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodTopAppBar(
    modifier: Modifier, title: String, basketItemCount: String, navigateToBasketPage: () -> Unit
) {
    TopAppBar(title = { Text(text = title, style = TextStyle(color = Color.White, fontSize = 18.sp)) }, actions = {
        Box(
            contentAlignment = Alignment.TopEnd, modifier = Modifier.size(50.dp)

        ) {
            IconButton(onClick = { navigateToBasketPage.invoke() }) {
                Icon(
                    imageVector = Icons.Default.ShoppingBasket,
                    contentDescription = "",
                    tint = Color.White,
                    modifier = modifier.size(40.dp)
                )
            }
            Box(
                modifier = modifier
                    .clip(CircleShape)
                    .background(Color.Red)
                    .size(25.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = basketItemCount, style = TextStyle(color = Color.White))
            }

        }

    }, colors = TopAppBarDefaults.topAppBarColors(MainColor)
    )
}

@Preview
@Composable
fun FoodTopAppBarPreview() {
    FoodTopAppBar(
        modifier = Modifier,
        title = stringResource(id = R.string.app_name),
        basketItemCount = "0",
        navigateToBasketPage = {}
    )
}