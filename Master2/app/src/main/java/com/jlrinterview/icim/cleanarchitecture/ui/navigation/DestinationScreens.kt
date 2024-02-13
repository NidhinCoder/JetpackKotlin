package com.jlrinterview.icim.cleanarchitecture.ui.navigation

sealed class DestinationScreens(val route:String) {
    data object Home:DestinationScreens("Home")
    data object Seats:DestinationScreens("Seats")
    data object Climate:DestinationScreens("Climate")
    data object Lighting:DestinationScreens("Lighting")
    data object Blinds:DestinationScreens("Blinds")
    data object RSE:DestinationScreens("RSE")
    data object Fridge:DestinationScreens("Fridge")
    data object HapticSeats:DestinationScreens("HapticSeats")
    data object Setting:DestinationScreens("Setting")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}