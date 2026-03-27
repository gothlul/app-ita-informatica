package com.itainformatica.components.cards

import android.annotation.SuppressLint
import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import kotlinx.coroutines.launch


@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun BottomSheet(
    modifier: Modifier = Modifier,
    borderRadius: Dp = 20.dp,
    simpleColor: Color = Color.LightGray,
    padding: PaddingValues = PaddingValues(all = 16.dp),
    bottomLimit: Float = 50f,
    topLimit: Float = 100f,
    content: @Composable () -> Unit
){
    val baseSize = LocalConfiguration.current.screenWidthDp.dp * 0.01f
    val baseHeight = LocalConfiguration.current.screenHeightDp.dp * 0.01f


    val density = LocalDensity.current

    val minHeight = with(receiver = density) { (baseHeight * bottomLimit).toPx() }
    val maxHeight = with(receiver = density) { (baseHeight * topLimit).toPx() }

    val height = remember { Animatable(initialValue = minHeight) }
    val scope = rememberCoroutineScope()

    Box(
        modifier = modifier
            .fillMaxWidth()
    ){
        Box(
            modifier = modifier
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(size = borderRadius),
                    clip = false
                )
                .fillMaxWidth()
                .height(with(receiver = density) { height.value.toDp() })
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(
                        topStart = borderRadius,
                        topEnd = borderRadius
                    )
                )
                .offset {
                    IntOffset(0, (maxHeight - height.value).toInt())
                },
            contentAlignment = Alignment.CenterStart
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .height(baseSize)
                            .width(baseSize * 25f)
                            .background(
                                color = simpleColor,
                                shape = RoundedCornerShape(size = 100.dp)
                            )
                            .draggable(
                                orientation = Orientation.Vertical,
                                state = rememberDraggableState { variation ->
                                    val newHeight = (height.value - variation)
                                        .coerceIn(minHeight, maxHeight)

                                    scope.launch {
                                        height.snapTo(targetValue = newHeight)
                                    }
                                },
                                onDragStopped = {
                                    scope.launch {
                                        val aceptInterval = (minHeight + maxHeight) / 2
                                        if (height.value > aceptInterval) {
                                            height.animateTo(targetValue = maxHeight)
                                        } else {
                                            height.animateTo(targetValue = minHeight)
                                        }
                                    }
                                }
                            )
                    )
                }

                Box(
                    modifier = Modifier
                        .padding(paddingValues = padding)
                        .fillMaxSize()
                ) {
                    content()
                }
            }
        }
    }
}