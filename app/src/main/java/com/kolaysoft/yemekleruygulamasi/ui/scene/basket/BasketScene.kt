import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.kolaysoft.yemekleruygulamasi.ui.scene.SharedViewModel

@Composable
fun BasketScene(modifier: Modifier, sharedViewModel: SharedViewModel = hiltViewModel()) {
    val meals by sharedViewModel.meal.collectAsState()

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (meals.isNotEmpty()) {
            Text(text = "Liste Sayısı: ${meals.size}")
            meals.forEach { meal ->
                Text(text = meal?.yemek_adi ?: "Boş Liste")
            }
        } else {
            Text(text = "Boş liste")
        }
    }
}
