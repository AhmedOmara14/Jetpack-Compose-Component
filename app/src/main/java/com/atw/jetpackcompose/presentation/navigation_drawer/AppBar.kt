package com.atw.jetpackcompose.presentation.navigation_drawer

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.atw.jetpackcompose.R

@Composable
fun AppBar(
    onNavigationIconClick:() ->Unit
) {
    TopAppBar(
        title = {
            Text(text = "App Bar", color = Color.White)
        },
        backgroundColor = colorResource(id = R.color.purple_700),
        contentColor = colorResource(id = R.color.purple_700),
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "drawer", tint = Color.White)
            }
        }
    )
}