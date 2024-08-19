package com.kolaysoft.yemekleruygulamasi.ui.scene.profile.widget

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.kolaysoft.yemekleruygulamasi.ui.theme.MainColor

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ProfilePageTopBar() {
    TopAppBar(
        title = { Text(text = "Profil", style = TextStyle(color = Color.White, fontSize = 18.sp)) },
        colors = TopAppBarDefaults.topAppBarColors(MainColor)
    )
}
