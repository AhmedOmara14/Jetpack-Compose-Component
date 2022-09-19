package com.atw.jetpackcompose.presentation.animation
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Preview
@Composable
fun Loading() {
    val circleSize = 25.dp
    val topDistance = 20.dp
    val spaceBetween = 10.dp
    val circleColor = MaterialTheme.colors.primary

    val circles = listOf(
        remember { Animatable(initialValue = 0f) },
        remember { Animatable(initialValue = 0f) },
        remember { Animatable(initialValue = 0f) }
    )

    circles.forEachIndexed { index, animatable ->
        LaunchedEffect(key1 = animatable) {
            delay(index * 100L)
            animatable.animateTo(
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                   animation = keyframes{
                       durationMillis =
                           2000
                       0.0f at 0 with LinearOutSlowInEasing
                       1.0f at 300 with LinearOutSlowInEasing
                       0.0f at 600 with LinearOutSlowInEasing
                       0.0f at 1200 with LinearOutSlowInEasing
                   }, repeatMode = RepeatMode.Restart
                )
            )
        }
    }

    val circleValue = circles.map { it.value }
    val distance = with(LocalDensity.current) { topDistance.toPx() }
    val lastCircle = circleValue.size - 1

    Row(
        modifier = Modifier.fillMaxWidth().padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        circleValue.forEachIndexed { index, fl ->
            Box(modifier = Modifier
                .size(circleSize)
                .fillMaxWidth()
                .graphicsLayer { translationY = -fl * distance }
                .background(circleColor, shape = CircleShape)
            )
            if (index != lastCircle)
                Spacer(modifier = Modifier.width(spaceBetween))
        }
    }
}