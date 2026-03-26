package com.itainformatica.components.navbar

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import com.itainformatica.R
import com.itainformatica.components.navbar.NavItem
import com.itainformatica.ui.theme.*

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun NavBar(
    modifier: Modifier = Modifier,
    navItems: List<NavItem>,
    color: Color = Color.Black,
    padding: PaddingValues? = null,
    itemsSize: Float = 14f
) {
    val baseSize = LocalConfiguration.current.screenWidthDp.dp * 0.01f
    var selectedIndex by remember { mutableIntStateOf(0) }

    val currentPadding = padding?: PaddingValues(
        top = baseSize * 0.05f,
        start = baseSize * 2.5f,
        end = baseSize * 2.5f,
        bottom = (baseSize * 14f)
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color)
            .padding(paddingValues = currentPadding)
            .graphicsLayer(clip = false),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        navItems.forEachIndexed { index, item ->
            val isSelected = selectedIndex == index
            val painter = item.icon?: painterResource(id = R.drawable.no_image)

            val elevation: Dp by animateDpAsState(if (isSelected) baseSize else 0.dp)
            val bgColor: Color by animateColorAsState(if (isSelected) White else Color.Transparent)
            val position: Dp by animateDpAsState(if (isSelected) -baseSize * 2 else 0.dp)

            Surface(
                modifier = Modifier
                    .size(baseSize * itemsSize)
                    .offset(y = position)
                    .shadow(
                        elevation = elevation,
                        shape = RoundedCornerShape(size = 100.dp)
                    )
                    .clickable {
                        selectedIndex = index
                        item.onTap()
                    },
                color = bgColor
            ) {
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(all = baseSize * 3f),
                    colorFilter = ColorFilter.tint(if(isSelected) color else item.iconColor)
                )
            }
        }
    }

}