package com.atw.jetpackcompose.presentation.widget.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.atw.jetpackcompose.R
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomNavigationBar(
    items: List<BottomNavigationItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavigationItem) -> Unit
) {
    BottomNavigation(
        modifier = modifier,
        backgroundColor = colorResource(id = R.color.purple_700),
        elevation = 5.dp
    ) {
        items.forEach {
            val selected =
                it.route == navController.currentBackStackEntryAsState().value?.destination?.route
            BottomNavigationItem(
                modifier=Modifier.padding(10.dp),
                selected = selected,
                onClick = { onItemClick(it) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.Gray,
                icon = {
                    Column {
                        if (it.badgeCount > 0) {
                            BadgeBox(
                                badgeContent = { Text(text = it.badgeCount.toString()) }
                            ) {
                                Icon(imageVector = it.icon, contentDescription = it.name)
                            }
                        } else {
                            Icon(imageVector = it.icon, contentDescription = it.name)
                        }
                        if (selected) {
                            Text(text = it.name, fontSize = 10.sp, textAlign = TextAlign.Center)
                        }
                    }
                })


        }

    }
}