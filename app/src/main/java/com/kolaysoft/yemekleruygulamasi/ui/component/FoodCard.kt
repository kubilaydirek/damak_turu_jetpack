package com.kolaysoft.yemekleruygulamasi.ui.component

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DirectionsBike
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.kolaysoft.yemekleruygulamasi.R
import com.kolaysoft.yemekleruygulamasi.ui.theme.GreenColor
import com.kolaysoft.yemekleruygulamasi.ui.theme.MainColor

@Composable
fun FoodCard(
    modifier: Modifier = Modifier,
    imageName: String,
    foodName: String,
    foodPrice: Int = 0,
    addButtonOnClick: () -> Unit
) {
    Card(
        modifier = modifier
            .height(350.dp)
            .width(250.dp)
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(7.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LikedButton()
            FoodImage(imageName = imageName, modifier = Modifier.size(120.dp))
            Spacer(modifier = Modifier.height(10.dp))
            FoodInfo(foodName, modifier)
            AddBasket(modifier, foodPrice, addButtonOnClick)

        }
    }
}


@Composable
private fun LikedButton() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Outlined.FavoriteBorder,
                contentDescription = "",
            )
        }
    }
}

@Composable
private fun FoodInfo(foodName: String, modifier: Modifier) {
    Text(
        text = foodName, style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color(0XFF171E48))
    )
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = Icons.Default.DirectionsBike,
            contentDescription = "",
            tint = GreenColor,
            modifier = modifier.size(13.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = stringResource(R.string.ucretsiz_gonderim), style = TextStyle(fontSize = 13.sp))
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
private fun AddBasket(modifier: Modifier, foodPrice: Int, addButtonOnClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp, 0.dp)
    ) {
        Box {
            Row {
                Text(
                    text = "₺", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color(0XFF171E48))
                )
                Text(
                    text = foodPrice.toString(),
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color(0XFF171E48))
                )
            }

        }
        Box(
            modifier = modifier
                .size(35.dp)
                .background(MainColor)
                .clip(shape = RoundedCornerShape(50.dp))
                .clickable { addButtonOnClick.invoke() },
            contentAlignment = Alignment.Center
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "", tint = Color.White)
        }
    }
}

@Preview
@Composable
fun foodCardPreview() {
    FoodCard(
        imageName = "http://kasimadalan.pe.hu/yemekler/resimler/su.png",
        foodName = "Test",
        foodPrice = 50,
        addButtonOnClick = {})
}
