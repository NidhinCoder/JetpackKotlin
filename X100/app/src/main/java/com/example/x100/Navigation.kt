package com.example.x100

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController


import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun Navigation(viewModel:RegisterViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home")
        { HomeScreen(navController = navController) }
        composable("login") {
            LoginScreen(navController = navController)
        }

        composable("register")
        {

            RegisterScreen(navController = navController,viewModel) }
    }
}