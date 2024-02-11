package com.example.revisionproject.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.revisionproject.ui.screens.ScreenBlinds
import com.example.revisionproject.ui.screens.ScreenClimate
import com.example.revisionproject.ui.screens.ScreenFridge
import com.example.revisionproject.ui.screens.ScreenHapticSeats
import com.example.revisionproject.ui.screens.ScreenLighting
import com.example.revisionproject.ui.screens.ScreenMain
import com.example.revisionproject.ui.screens.ScreenRSE
import com.example.revisionproject.ui.screens.ScreenSeats
import com.example.revisionproject.ui.screens.ScreenSettings

@Composable
fun Navigation() {
    val navigationController = rememberNavController()

    NavHost(navController = navigationController,
            startDestination = Destinations.Home.route){

            composable(Destinations.Home.route) { ScreenMain(navigationController) }
            composable(Destinations.Seats.route) { ScreenSeats(navigationController) }
            composable(Destinations.Climate.route) { ScreenClimate(navigationController) }
            composable(Destinations.Lighting.route) { ScreenLighting(navigationController) }
            composable(Destinations.Blinds.route) { ScreenBlinds(navigationController) }
            composable(Destinations.RSE.route) { ScreenRSE(navigationController) }
            composable(Destinations.Fridge.route) { ScreenFridge(navigationController) }
            composable(Destinations.HapticSeats.route) { ScreenHapticSeats(navigationController) }
            composable(Destinations.Setting.route) { ScreenSettings(navigationController) }

    }
}