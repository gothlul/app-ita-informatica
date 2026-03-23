import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.graphicsLayer

@Composable
fun NavBar(
    navItems: List<NavItem>,
    background: Color = Color.Gray
) {
    var selectedIndex by remember { mutableStateOf(0) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(background)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        navItems.forEachIndexed { index, item ->
            val isSelected = selectedIndex == index

            val elevation: Dp by animateDpAsState(if (isSelected) 8.dp else 0.dp)
            val bgColor: Color by animateColorAsState(if (isSelected) item.color else Color.Transparent)
            val scale: Float by animateFloatAsState(if (isSelected) 1.2f else 1f)

            Surface(
                modifier = Modifier
                    .size(50.dp)
                    .shadow(elevation)
                    .background(bgColor)
                    .clickable {
                        selectedIndex = index
                        item.onTap()
                    }
                    .graphicsLayer { scaleX = scale; scaleY = scale },
                shape = CircleShape,
                color = Color.Transparent
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = null,
                    tint = if (isSelected) Color.White else Color.Black,
                    modifier = Modifier.padding(12.dp)
                )
            }
        }
    }
}