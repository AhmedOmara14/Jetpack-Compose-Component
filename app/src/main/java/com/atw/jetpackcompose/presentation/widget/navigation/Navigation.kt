package com.atw.jetpackcompose.presentation.widget.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.atw.jetpackcompose.presentation.widget.navigation.screens.ChatScreen
import com.atw.jetpackcompose.presentation.widget.navigation.screens.HomeScreen
import com.atw.jetpackcompose.presentation.widget.navigation.screens.SettingsScreen

@Composable
fun Navigation(navHostController: NavHostController) {

    NavHost(navController = navHostController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("chat") {
            ChatScreen()
        }
        composable("settings") {
            SettingsScreen()
        }
    }
}