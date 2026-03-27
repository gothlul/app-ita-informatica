package com.itainformatica.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.itainformatica.R

@Composable
fun CategoryCard(
    modifier: Modifier = Modifier,
    title: String = "",
    imageUrl: String = "",
    onTap: () -> Unit,
    borderRadius: Dp = 100.dp,
    fontSize: Float = 10f,
    imageSize: Float = 18f,
    padding: PaddingValues = PaddingValues(all = 14.dp)
) {

    val baseSize = LocalConfiguration.current.screenWidthDp.dp * 0.01f

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .clickable {
                onTap()
            },
    ){
        Box(
            modifier = modifier
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(size = borderRadius),
                    clip = false
                )
                .background(Color.White, shape = RoundedCornerShape(size = borderRadius))
                .padding(paddingValues = padding),
            contentAlignment = Alignment.CenterStart
        ){
            if(imageUrl.isEmpty() || imageUrl == ""){
                Image(
                    painter = painterResource(id = R.drawable.no_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = imageSize.dp, height = imageSize.dp)
                )
            }else{
                AsyncImage(
                    model = imageUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = imageSize.dp, height = imageSize.dp)
                )
            }

        }
        Spacer(modifier = Modifier.height((fontSize * 0.5).dp))
        Text(
            title,
            fontSize = fontSize.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(baseSize * 20)
        )
    }
}