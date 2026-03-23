import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.Color

data class NavItem(
    val icon: ImageVector,
    val color: Color = Color.Black,
    val onTap: () -> Unit
)