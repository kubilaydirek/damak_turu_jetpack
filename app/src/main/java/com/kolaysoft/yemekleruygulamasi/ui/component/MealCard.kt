package com.kolaysoft.yemekleruygulamasi.ui.component

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MealCard(modifier: Modifier = Modifier, imageName: String, mealName: String, buttonOnclick: () -> Unit) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(15.dp)
    ) {
        Column(
            modifier = Modifier.padding(7.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ImageNetwork(imageName = imageName, modifier = Modifier.size(120.dp))
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = mealName,
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 15.sp)
            )
            Button(onClick = { buttonOnclick.invoke() }) {
                Text(text = "Sepete Ekle")
            }
        }
    }
}

@Composable
fun ImageNetwork(imageName: String, modifier: Modifier) {
    val painter = rememberAsyncImagePainter(
        "http://kasimadalan.pe.hu/yemekler/resimler/${imageName}",
    )
    Image(painter = painter, contentDescription = "", modifier = modifier)
}

@Preview
@Composable
fun MealCardPreview() {
    MealCard(imageName = "test_image.jpg", mealName = "Test") {}
}
