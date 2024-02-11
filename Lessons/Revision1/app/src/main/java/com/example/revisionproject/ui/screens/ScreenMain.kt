package com.example.revisionproject.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.revisionproject.ui.navigation.Destinations
import com.example.revisionproject.ui.reusablecomponents.FeatureIButton


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
                               imageResourceName = buttonName,
                               featureName =buttonName
                              )
            }
        }

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


