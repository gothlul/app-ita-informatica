package com.itainformatica.components.fields
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.w3c.dom.Text

@Composable
fun SearchField(
    modifier: Modifier = Modifier,
    hint: String = "Pesquisar...",
    color: Color = Color(0xFFFAFAFA),
    textColor: Color = Color.Black,
    height: Float = 50f,
    width: Float = -1f,
    borderRadius: Dp = 100.dp,
    padding: PaddingValues = PaddingValues(all = 10.dp),
    spacing: Dp = 10.dp,
    onSearch: (String) -> Unit
) {
    var currentText by remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(size = borderRadius),
                clip = false
            )
            .background(if(currentText.isEmpty()) color else Color.White, shape = RoundedCornerShape(size = borderRadius))
            .then(
                other = if (width <= 0f) Modifier.fillMaxWidth() else Modifier.width(width.dp)
            ),
        contentAlignment = Alignment.CenterStart
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = padding.calculateStartPadding(LayoutDirection.Ltr))
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Pesquisar",
                tint = if(currentText.isEmpty()) textColor.copy(alpha = 0.6f) else textColor ,
                modifier = Modifier
                    .size((height * 0.5f).dp)
            )
            Spacer(modifier = Modifier.width(spacing))
            BasicTextField(
                value = currentText,
                onValueChange = { newText ->
                    currentText = newText
                    onSearch(newText)
                },
                singleLine = true,
                cursorBrush = SolidColor(
                    value = textColor
                ),
                textStyle = TextStyle(
                    fontSize = (height * 0.35f).sp,
                    color = Color.Black
                ),
                decorationBox = { innerTextField ->
                    Box(
                        contentAlignment = Alignment.TopStart,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(height.dp)
                            .padding(vertical = padding.calculateTopPadding())
                    ) {
                        if (currentText.isEmpty()) {
                            Text(
                                text = hint,
                                color = textColor.copy(alpha = 0.6f),
                                fontSize = (height * 0.35f).sp,
                                lineHeight = (height * 0.35f).sp
                            )
                        }
                        innerTextField()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}