import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.itainformatica.R
import com.itainformatica.ui.theme.*

@Composable
fun MainPage(
    modifier: Modifier = Modifier,
    padding: PaddingValues = PaddingValues(horizontal = 24.dp),
    content: @Composable () -> Unit
) {
    val baseSize = LocalConfiguration.current.screenWidthDp.dp * 0.01f

    Scaffold (
        modifier = modifier
            .fillMaxSize(),
        containerColor = Color.White,
        bottomBar = {
            NavBar(
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
                .padding(
                    top = innerPadding.calculateTopPadding() + (baseSize * 8f),
                    end = padding.calculateEndPadding(LayoutDirection.Ltr),
                    start = padding.calculateStartPadding(LayoutDirection.Ltr),
                    bottom = innerPadding.calculateBottomPadding()
                ),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_welder),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(width = 148.dp, height = 40.dp)
                    .padding(bottom = baseSize * 2)
            )

            content()

        }
    }
}