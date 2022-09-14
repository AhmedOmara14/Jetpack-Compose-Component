package com.atw.jetpackcompose.presentation.animation

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atw.jetpackcompose.R

@Preview
@Composable
fun ProgressLoading() {
    Column(
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        CircularProgressIndicator(color = colorResource(id = R.color.purple_700))
        Spacer(modifier = Modifier.height(15.dp))
        LinearProgressIndicator(color = colorResource(id = R.color.purple_700))
    }
}