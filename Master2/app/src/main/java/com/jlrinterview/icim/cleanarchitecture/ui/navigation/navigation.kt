package com.jlrinterview.icim.cleanarchitecture.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jlrinterview.icim.R
import com.jlrinterview.icim.cleanarchitecture.ui.constants.DimensionValues.middlePanel_width
import com.jlrinterview.icim.cleanarchitecture.ui.constants.DimensionValues.sidebar_bottom_padding
import com.jlrinterview.icim.cleanarchitecture.ui.constants.DimensionValues.sidebar_width
import com.jlrinterview.icim.cleanarchitecture.ui.reusableuicomponents.ImageButton
import com.jlrinterview.icim.cleanarchitecture.ui.screens.BlindsScreen
import com.jlrinterview.icim.cleanarchitecture.ui.screens.ClimateScreen
import com.jlrinterview.icim.cleanarchitecture.ui.screens.FridgeScreen
import com.jlrinterview.icim.cleanarchitecture.ui.screens.HapticSeatsScreen
import com.jlrinterview.icim.cleanarchitecture.ui.screens.HomeScreen
import com.jlrinterview.icim.cleanarchitecture.ui.screens.LightingScreen
import com.jlrinterview.icim.cleanarchitecture.ui.screens.RSEScreen
import com.jlrinterview.icim.cleanarchitecture.ui.screens.SeatsScreen
import com.jlrinterview.icim.cleanarchitecture.ui.screens.SettingsScreen
import com.jlrinterview.icim.cleanarchitecture.ui.viewmodel.HomeScreenViewModel

@Composable
fun ApplicationGUI(uiState: State<HomeScreenViewModel.HomeScreenFeaturesListState>) {

    Box(){

        BackgroundImage()

        //Entire application screens will be rendered on top of background image
        IcimPanels(uiState)

    }

}

@Composable
fun BackgroundImage() {
    //It is application's main background
    Image(modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds,
        painter = painterResource(id = R.drawable.main_screen_bg) , contentDescription = "")
}

@Composable
fun IcimPanels(uiState: State<HomeScreenViewModel.HomeScreenFeaturesListState>) {

    //We split the screen to 3 parts
   Row(
       horizontalArrangement = Arrangement.SpaceBetween
   ){

        //ICIM's resolution is 1280 pixels and in Android environment it is 640.dp
        //This width is splitted to 2 equal sized sidebars and one middle panel area

        //Left side bar
        SideBar(R.drawable.home)

        //Middle panel area
        //It will contain all the screens and transitions. Content is dynamic
        MiddlePanel(uiState)

        //Right sidebar
        SideBar(R.drawable.settings)
   }
}


@Composable
fun SideBar(imageId:Int) {

    Box(modifier= Modifier
        .fillMaxHeight()
        .width(sidebar_width)){
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(sidebar_bottom_padding)
        ){
            ImageButton(imageId = imageId)
        }

    }

}

@Composable
fun MiddlePanel(uiState: State<HomeScreenViewModel.HomeScreenFeaturesListState>) {
    Box(modifier= Modifier
        .fillMaxHeight()
        .width(middlePanel_width)){
        IcimNavigator(uiState)
    }
}

@Composable
fun IcimNavigator(uiState: State<HomeScreenViewModel.HomeScreenFeaturesListState>) {
    val navigationController = rememberNavController()
    NavHost(
        navController = navigationController,
        startDestination = DestinationScreens.Home.route
    ) {


        composable(DestinationScreens.Home.route) { HomeScreen(uiState,navigationController) }
        composable(DestinationScreens.Seats.route) { SeatsScreen(navigationController) }
        composable(DestinationScreens.Climate.route) { ClimateScreen(navigationController) }
        composable(DestinationScreens.Lighting.route) { LightingScreen(navigationController) }
        composable(DestinationScreens.Blinds.route) { BlindsScreen(navigationController) }
        composable(DestinationScreens.RSE.route) { RSEScreen(navigationController) }
        composable(DestinationScreens.Fridge.route) { FridgeScreen(navigationController) }
        composable(DestinationScreens.HapticSeats.route) { HapticSeatsScreen(navigationController) }
        composable(DestinationScreens.Setting.route) { SettingsScreen(navigationController) }
    }

}


