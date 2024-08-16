import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kolaysoft.yemekleruygulamasi.R
import com.kolaysoft.yemekleruygulamasi.data.model.FoodModel
import com.kolaysoft.yemekleruygulamasi.ui.component.FoodAlertDialog
import com.kolaysoft.yemekleruygulamasi.ui.component.bottom_nav.BottomNavItem
import com.kolaysoft.yemekleruygulamasi.ui.component.bottom_nav.FoodBottomNavigation
import com.kolaysoft.yemekleruygulamasi.ui.scene.basket.BasketViewModel
import com.kolaysoft.yemekleruygulamasi.ui.scene.basket.widget.BasketCard
import com.kolaysoft.yemekleruygulamasi.ui.scene.basket.widget.BasketPageTopBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BasketScene(
    modifier: Modifier,
    basketViewModel: BasketViewModel,
    onNavigateToHome: () -> Unit,
    onNavigateToProfile: () -> Unit,
    onNavigateToFavorite: () -> Unit,
    onNavigateToBasket: () -> Unit,
    navigateToBack: () -> Unit
) {
    val meals by basketViewModel.meal.collectAsState()
    val totalAmount by basketViewModel.totalAmount.collectAsState()
    val openAlertDialog = remember { mutableStateOf(false) }
    val selectedItem = remember { mutableStateOf<FoodModel.Yemekler?>(null) }

    LaunchedEffect(Unit) {
        basketViewModel.totalAmount()
    }

    Scaffold(topBar = {
        BasketPageTopBar(navigateToBack)
    }, content = { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (meals.isNotEmpty()) {
                LazyColumn(modifier = Modifier.weight(1f)) {
                    items(meals) { item ->
                        BasketCard(modifier = modifier,
                            imageName = item?.yemek_resim_adi ?: "",
                            foodName = item?.yemek_adi ?: "",
                            foodPrice = item?.yemek_fiyat?.toInt() ?: 0,
                            foodPiece = item?.quantity ?: 0,
                            deleteIconOnPress = {
                                selectedItem.value = item
                                openAlertDialog.value = true
                            })
                    }
                }
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = stringResource(R.string.bos_sepet))
                }
            }

            Text(
                text = stringResource(R.string.sepet_toplami, totalAmount),
                modifier = Modifier.padding(16.dp),
                style = TextStyle(fontSize = 20.sp, color = Color.Black, fontWeight = FontWeight.Bold)
            )
        }
        when {
            openAlertDialog.value -> FoodAlertDialog(
                onDismissRequest = { openAlertDialog.value = false },
                onConfirmation = {
                    selectedItem.value.let { item ->
                        basketViewModel.deleteBasketMeal(item!!)
                    }
                    openAlertDialog.value = false
                },
                dialogTitle = stringResource(R.string.silmek_istediginize_emin_misiniz),
                dialogText = "",
            )
        }
    }, bottomBar = {
        FoodBottomNavigation(
            onNavigateToHome = { onNavigateToHome.invoke() },
            onNavigateToProfile = { onNavigateToProfile.invoke() },
            onNavigateToFavorite = { onNavigateToFavorite.invoke() },
            onNavigateToBasket = { onNavigateToBasket.invoke() },
            selectedItem = BottomNavItem.Basket
        )
    })
}


