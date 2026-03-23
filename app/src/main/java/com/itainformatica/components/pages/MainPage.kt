import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.itainformatica.R

@Composable
fun MainPage(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.logo_welder),
            contentDescription = "Logo",
            modifier = Modifier.size(width = 74.dp, height = 20.dp)
        )

        content()
    }
}