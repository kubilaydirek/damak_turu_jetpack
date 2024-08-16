package com.kolaysoft.yemekleruygulamasi.ui.scene.basket.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.kolaysoft.yemekleruygulamasi.R
import com.kolaysoft.yemekleruygulamasi.ui.theme.MainColor

@Composable
fun BasketCard(
    modifier: Modifier,
    imageName: String,
    foodName: String,
    foodPrice: Int,
    foodPiece: Int,
    deleteIconOnPress: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(130.dp)
            .shadow(1.dp)
            .padding(20.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                FoodImage(imageName = imageName, modifier = modifier)
            }
            Box(
                modifier = modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .fillMaxHeight()
                    .padding(10.dp)
            ) {
                FoodDetail(modifier, foodName, foodPrice, foodPiece)

            }
            Box(
                modifier = modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconButton(onClick = { deleteIconOnPress.invoke() }) {
                        Icon(imageVector = Icons.Default.Delete, contentDescription = "", tint = MainColor)
                    }
                    Text(
                        text = "${foodPiece * foodPrice} ₺",
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    )
                }
            }
        }
    }
}


@Composable
fun FoodImage(imageName: String, modifier: Modifier) {
    val painter = rememberAsyncImagePainter(
        "http://kasimadalan.pe.hu/yemekler/resimler/${imageName}",
    )
    Image(painter = painter, contentDescription = "", modifier = modifier)
}

@Composable
private fun FoodDetail(
    modifier: Modifier,
    foodName: String,
    foodPrice: Int,
    foodPiece: Int
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = foodName, style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp))
        Text(
            text = stringResource(R.string.fiyat, foodPrice),
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)
        )
        Text(
            text = stringResource(R.string.adet, foodPiece),
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)
        )
    }
}

@Preview
@Composable
fun BasketCardPreview() {
    BasketCard(modifier = Modifier, imageName = "", foodName = "Test", foodPrice = 50, foodPiece = 2, deleteIconOnPress = {})
}