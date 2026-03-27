package com.itainformatica.components.cards

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.itainformatica.R
import com.itainformatica.components.flags.CategoryFlag
import com.itainformatica.models.Category

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    itemName: String = "",
    price: Float = 0f,
    imageUrl: String? = null,
    categories: List<Category>,
    color: Color = Color.Black,
    containerColor: Color = Color.White,
    priceColor: Color = Color.Gray,
    borderRadius: Dp = 10.dp,
    padding: PaddingValues = PaddingValues(all = 10.dp),
    spacing: Dp = 5.dp,
    fontSize: Float = 16f,
    onTap: () -> Unit,
) {
    val baseSize = LocalConfiguration.current.screenWidthDp.dp * 0.01f
    val maxWidth = LocalConfiguration.current.screenWidthDp.dp * 0.4f

    val categoryScrollState = rememberScrollState()

    Box(
        modifier = modifier
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(size = borderRadius),
                clip = false
            )
            .background(containerColor, shape = RoundedCornerShape(size = borderRadius))
            .widthIn(max = maxWidth)
            .heightIn(max = baseSize * 65)
            .clickable(
                onClick = {
                    onTap()
                }
            ),
        contentAlignment = Alignment.CenterStart
    ) {
        Column{
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        shape = RoundedCornerShape(
                            topEnd = borderRadius,
                            topStart = borderRadius
                        ),
                    )
            ){
                if(imageUrl == null || imageUrl == ""){
                    Image(
                        painter = painterResource(id = R.drawable.no_image),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(120.dp)
                    )
                }else{
                    AsyncImage(
                        model = imageUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(120.dp)
                    )
                }
            }
            Box(
                modifier = Modifier
                    .padding(
                        top = baseSize * 3f,
                        bottom = padding.calculateBottomPadding(),
                        start = padding.calculateStartPadding(LayoutDirection.Ltr),
                        end = padding.calculateEndPadding(LayoutDirection.Ltr)
                    )
            ){
                Column(
                    verticalArrangement = Arrangement.spacedBy(spacing)
                ) {
                    Row(
                        modifier = Modifier
                            .horizontalScroll(categoryScrollState),
                        horizontalArrangement = Arrangement.spacedBy(3.dp)
                    ){
                        categories.forEach { item ->
                            CategoryFlag(
                                title = item.name,
                                color = color,
                            )
                        }
                    }
                    Row{
                        Text(
                            itemName,
                            maxLines = 2,
                            fontSize = fontSize.sp,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Row {
                        Text(
                            "R$ ${"%.2f".format(price)}",
                            modifier = Modifier
                                .fillMaxWidth(),
                            color = priceColor,
                            textAlign = TextAlign.End,
                        )
                    }
                }
            }
        }
    }
}