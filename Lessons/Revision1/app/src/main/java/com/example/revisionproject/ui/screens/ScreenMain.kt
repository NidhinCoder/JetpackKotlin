package com.example.revisionproject.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.revisionproject.ui.navigation.Destinations
import com.example.reusablecomposefunctions.FeatureIButton
import com.example.revisionproject.R


@Composable
fun ScreenMain(navController: NavHostController?) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("HOME Screen")
        val buttonList = listOf("seats", "climate", "lighting", "blinds", "rse","fridge","haptic")
        LazyColumn()
        {
            items(buttonList){
                buttonName->
                FeatureIButton(onClick = {
                                            navController?.navigate(getScreenRoute(buttonName))
                                         },
                               imageResourceId = getImageResourceId(buttonName),
                               featureName =buttonName
                              )
            }
        }

    }
}

fun getImageResourceId(buttonName: String): Int {
    return when (buttonName){
        "seats"-> R.drawable.seats
        "climate"->R.drawable.climate
        "lighting"->R.drawable.lighting
        "blinds"->R.drawable.blinds
        "rse"->R.drawable.rse
        "fridge"->R.drawable.fridge
        "haptic"->R.drawable.haptic
        "settings"->R.drawable.seats
        else ->R.drawable.seats
    }
}

fun getScreenRoute(name:String):String{

    val result = when(name){
        "seats"->Destinations.Seats.route
        "climate"->Destinations.Climate.route
        "lighting"->Destinations.Lighting.route
        "blinds"->Destinations.Blinds.route
        "rse"->Destinations.RSE.route
        "fridge"->Destinations.Fridge.route
        "haptic"->Destinations.HapticSeats.route
        "settings"->Destinations.Setting.route
        else ->Destinations.Home.route
    }

return result
}


