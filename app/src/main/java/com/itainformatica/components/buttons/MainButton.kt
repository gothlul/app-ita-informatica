import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun MainButton(
    modifier: Modifier = Modifier,
    text: String?,
    onTap: () -> Unit,
    color: Color? = Color.Blue,
    borderRadius: Dp? = 12.dp,
    textColor: Color? = Color.White,
) {
    Button(
        onClick = onTap,
        colors = ButtonDefaults.buttonColors(containerColor = color?:Color.Black),
        shape = RoundedCornerShape(borderRadius?:20.dp),
        modifier = modifier
    ) {
        Text(
            text = text?:"",
            color = textColor?:Color.Black
        )
    }
}