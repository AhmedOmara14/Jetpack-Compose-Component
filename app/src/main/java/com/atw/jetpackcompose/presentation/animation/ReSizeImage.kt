package com.atw.jetpackcompose.presentation.animation

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atw.jetpackcompose.R

@Preview
@Composable
fun ReSizeImage() {
    var isOpen by remember { mutableStateOf(false) }
    var isOpenTwo by remember { mutableStateOf(false) }
    val imageSize by animateDpAsState(targetValue = if (isOpen) 100.dp else 210.dp)
    val imageSizeTwo by animateDpAsState(targetValue = if (isOpenTwo) 100.dp else 205.dp)
    val roundedPercentage by animateFloatAsState(targetValue = if (isOpen) 0f else 50f)
    val roundedPercentageTwo by animateFloatAsState(targetValue = if (isOpenTwo) 0f else 50f)

    Row {
        Card(
            modifier = Modifier
                .width(imageSize)
                .height(imageSize)
                .padding(10.dp)
                .clickable {
                    isOpenTwo = isOpen
                    isOpen = !isOpen
                }
                .clip(RoundedCornerShape(roundedPercentage)),
            shape = RoundedCornerShape(20.dp),
            elevation = 5.dp

        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    modifier = Modifier
                        .fillMaxSize(),
                    painter = painterResource(id = R.drawable.office),
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds
                )
            }
        }
        Card(
            modifier = Modifier
                .width(imageSizeTwo)
                .height(imageSizeTwo)
                .padding(10.dp)
                .clickable {
                    isOpen = isOpenTwo
                    isOpenTwo = !isOpenTwo
                }
                .clip(RoundedCornerShape(roundedPercentageTwo)),
            shape = RoundedCornerShape(20.dp),
            elevation = 5.dp

        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    modifier = Modifier
                        .fillMaxSize(),
                    painter = painterResource(id = R.drawable.office),
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds
                )
            }
        }
    }
}