package com.example.revisionproject.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.revisionproject.ui.navigation.Destinations

@Composable
fun ScreenBlinds(navigationController: NavHostController?) {

    Box(Modifier.fillMaxSize()){
        Text(text = "BLINDS")

        Button(onClick = {
            navigationController?.navigate(Destinations.Seats.route)
        }) {
            Text(text = "Go to seats")
        }
    }
}