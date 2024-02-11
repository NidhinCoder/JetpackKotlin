package com.example.revisionproject.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun ScreenSettings(navigationController: NavHostController?) {

    Box(Modifier.fillMaxSize()){
        Text(text = "SETTINGS")
    }
}