package com.sumin.composeanimations.ui.screen

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Test() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .verticalScroll(
                state = rememberScrollState(),
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var isIncreased by remember {
            mutableStateOf(true)
        }

        // вернёт State<Dp>, а не Dp, потому что значение меняется динамически, а не сразу получим какое-то одно
        // поэтому нужно использовать size.value (или вместо "=" использовать делегат by)
        val size by animateDpAsState(targetValue = if (isIncreased) 200.dp else 100.dp)

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                isIncreased = !isIncreased
            }
        ) {
            Text(
                text = "Animate size",
            )
        }
        AnimatedContainer(
            text = "Size",
            size = size
        )

        var isRect by remember {
            mutableStateOf(true)
        }
        val radius by animateIntAsState(targetValue = if (isRect) 4 else 50)

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                isRect = !isRect
            }
        ) {
            Text(
                text = "Animate shape",
            )
        }
        AnimatedContainer(
            text = "Shape",
            radiusPercent = radius
        )

        var isSelected by remember {
            mutableStateOf(false)
        }
        val borderWidth by animateDpAsState(targetValue = if (isSelected) 4.dp else 0.dp)

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                isSelected = !isSelected
            }
        ) {
            Text(
                text = "Animate border",
            )
        }
        AnimatedContainer(
            text = "Border",
            borderWidth = borderWidth,
        )

        var isBlue by remember {
            mutableStateOf(true)
        }
        val backgroundColor by animateColorAsState(targetValue = if (isBlue) Color.Blue else Color.Red)

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                isBlue = !isBlue
            }
        ) {
            Text(
                text = "Animate color",
            )
        }
        AnimatedContainer(
            text = "Color",
            backgroundColor = backgroundColor
        )

        var isVisible by remember {
            mutableStateOf(true)
        }
        val alpha by animateFloatAsState(targetValue = if (isVisible) 1F else 0F)


        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                isVisible = !isVisible
            }
        ) {
            Text(
                text = "Animate visibility",
            )
        }
        AnimatedContainer(
            text = "Visibility",
            alpha = alpha
        )
    }
}

@Composable
private fun AnimatedContainer(
    text: String,
    size: Dp = 200.dp,
    radiusPercent: Int = 4,
    borderWidth: Dp = 0.dp,
    backgroundColor: Color = Color.Blue,
    alpha: Float = 1F,
) {
    Box(
        modifier = Modifier
            .alpha(alpha)
            .clip(RoundedCornerShape(radiusPercent))
            .border(width = borderWidth, color = Color.Black)
            .background(backgroundColor)
            .size(size),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.White
        )
    }
}
