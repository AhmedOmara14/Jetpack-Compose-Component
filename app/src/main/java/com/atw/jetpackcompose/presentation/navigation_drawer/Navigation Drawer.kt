package com.atw.jetpackcompose.presentation.navigation_drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atw.jetpackcompose.R

@Composable
fun DrawerHeader() {
    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.purple_700))
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Header",
            modifier = Modifier.padding(50.dp),
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 40.sp
        )
    }
}


@Composable
fun DrawerBody(
    items: List<MenuItem>,
    modifier: Modifier = Modifier,
    onItemClick: (MenuItem) -> Unit
) {
    LazyColumn() {
        items(items) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clickable { onItemClick(it) }) {
                Icon(imageVector = it.icon, contentDescription = it.title)
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = it.title, fontSize = 18.sp)
            }
        }
    }

}