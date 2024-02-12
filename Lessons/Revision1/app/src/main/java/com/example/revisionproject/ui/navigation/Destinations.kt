package com.example.revisionproject.ui.navigation

sealed class Destinations(val route:String) {


    object Home:Destinations("Home")

    //One pop up
    object Setting:Destinations("Setting")

    //Seven features
    object Seats:Destinations("Seats")
    object Climate:Destinations("Climate")
    object Lighting:Destinations("Lighting")
    object Blinds:Destinations("Blinds")
    object RSE:Destinations("RSE")
    object Fridge:Destinations("Fridge")
    object HapticSeats:Destinations("Haptic")


    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}

