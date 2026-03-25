import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.itainformatica.R
import com.itainformatica.ui.theme.*

@Composable
fun MainPage(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Scaffold (
        bottomBar = {
            NavBar(
                padding = WindowInsets.navigationBars.asPaddingValues(),
                color = Primary,
                navItems = listOf(
                    NavItem(
                        icon = painterResource(id = R.drawable.bag),
                        iconColor = DarkBlue,
                        onTap = {}),
                    NavItem(
                        icon = painterResource(id = R.drawable.compass),
                        iconColor = DarkBlue,
                        onTap = {}),
                    NavItem(
                        icon = painterResource(id = R.drawable.processor),
                        iconColor = DarkBlue,
                        onTap = {})
                )
            )
        }
    ){ innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = innerPadding.calculateTopPadding()),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_welder),
                contentDescription = "Logo",
                modifier = Modifier.size(width = 74.dp, height = 20.dp)
            )

            content()

        }
    }
}