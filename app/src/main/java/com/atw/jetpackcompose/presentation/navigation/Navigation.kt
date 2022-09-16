package com.atw.jetpackcompose.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.HomeScreen.route) {
        composable(route = Screens.HomeScreen.route) {
            HomeScreen(navController = navController)
        }

        composable(
            route = Screens.DetailsScreen.route+"/{name}", arguments = listOf(
                navArgument("name") {
                    defaultValue = ""
                    type = NavType.StringType
                    nullable =true
                }
            )
        ) {
            DetailsScreen(name = it.arguments?.getString("name"))
        }
    }
}