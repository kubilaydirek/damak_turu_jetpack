import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kolaysoft.yemekleruygulamasi.ui.component.bottom_nav.BottomNavItem
import com.kolaysoft.yemekleruygulamasi.ui.component.bottom_nav.FoodBottomNavigation
import com.kolaysoft.yemekleruygulamasi.ui.scene.basket.BasketViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BasketScene(
    modifier: Modifier,
    basketViewModel: BasketViewModel,
    onNavigateToHome: () -> Unit,
    onNavigateToProfile: () -> Unit,
    onNavigateToFavorite: () -> Unit,
    onNavigateToBasket: () -> Unit
) {
    val meals by basketViewModel.meal.collectAsState()

    Scaffold(
        content = {
            Column(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (meals.isNotEmpty()) {
                    LazyVerticalGrid(
                        modifier = modifier,
                        columns = GridCells.Fixed(2),
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        contentPadding = PaddingValues(bottom = 30.dp, top = 10.dp, start = 5.dp),
                    ) {
                        items(meals) { item ->
                            Text(text = item?.yemek_adi ?: "")
                            Text(text = item?.quantity.toString())
                        }
                    }
                } else {
                    Text(text = "Boş liste")
                }
            }
        },
        bottomBar = {
            FoodBottomNavigation(
                onNavigateToHome = { onNavigateToHome.invoke() },
                onNavigateToProfile = { onNavigateToProfile.invoke() },
                onNavigateToFavorite = { onNavigateToFavorite.invoke() },
                onNavigateToBasket = { onNavigateToBasket.invoke() },
                selectedItem = BottomNavItem.Basket
            )
        }
    )

}
