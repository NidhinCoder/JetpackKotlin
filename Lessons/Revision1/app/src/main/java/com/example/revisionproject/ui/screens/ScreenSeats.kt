package com.example.revisionproject.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController


@Composable
fun ScreenSeats(navigationController: NavHostController?) {

    Box(Modifier.fillMaxSize()){
        Text(text = "SEATS")
    }
}