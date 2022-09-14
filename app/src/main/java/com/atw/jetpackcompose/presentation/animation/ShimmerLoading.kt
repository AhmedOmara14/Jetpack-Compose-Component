package com.atw.jetpackcompose.presentation.animation

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun ShimmerLoading() {
    //ShimmerEffect
    val shimmerColors = listOf(
        Color.Gray.copy(0.5f),
        Color.Gray.copy(0.2f),
        Color.Gray.copy(0.2f)
    )

    val transition = rememberInfiniteTransition()
    val transitionAnimation = transition.animateFloat(
        initialValue = 0f,
        targetValue = 2000f,
        animationSpec = infiniteRepeatable(
            tween(
                durationMillis = 2000,
                easing = FastOutLinearInEasing
            ), repeatMode = RepeatMode.Reverse
        )
    )
    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset(0f, 0f),
        end = Offset(transitionAnimation.value, transitionAnimation.value)
    )
    Column(modifier = Modifier.padding(10.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
                    .background(brush)
            )

            Column(modifier = Modifier.padding(10.dp)) {
                Row(modifier = Modifier.fillMaxWidth().height(20.dp)) {
                    Text(text = "", modifier = Modifier
                        .height(15.dp)
                        .weight(1.5f)
                        .background(brush = brush))
                    Divider(modifier = Modifier.weight(0.05f))
                    Text(text = "", modifier = Modifier
                        .height(15.dp)
                        .weight(0.5f)
                        .background(brush = brush))
                }
                Text(text = "", modifier = Modifier
                    .height(20.dp)
                    .fillMaxWidth()
                    .padding(0.dp,5.dp,0.dp,0.dp)
                    .background(brush = brush))

            }

        }
        Text(text = "", modifier = Modifier
            .height(30.dp)
            .fillMaxWidth()
            .padding(0.dp,5.dp,0.dp,0.dp)
            .background(brush = brush))
    }
}