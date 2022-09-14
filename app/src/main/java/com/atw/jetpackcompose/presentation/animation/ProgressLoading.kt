package com.atw.jetpackcompose.presentation.animation

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.atw.jetpackcompose.R

@Preview
@Composable
fun ProgressLoading() {
    CircularProgressIndicator(color = colorResource(id = R.color.purple_700))

    LinearProgressIndicator(color = colorResource(id = R.color.purple_700))
}