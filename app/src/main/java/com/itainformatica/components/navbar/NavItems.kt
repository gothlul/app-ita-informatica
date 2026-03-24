import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

class NavItem(
    val icon: Painter,
    val iconColor: Color = Color.Black,
    val onTap: () -> Unit
){}