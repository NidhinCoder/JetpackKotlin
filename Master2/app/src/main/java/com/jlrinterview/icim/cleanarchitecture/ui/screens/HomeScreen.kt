package com.jlrinterview.icim.cleanarchitecture.ui.screens

import android.provider.SyncStateContract.Columns
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.State
import androidx.compose.ui.unit.dp
import com.jlrinterview.icim.cleanarchitecture.ui.viewmodel.HomeScreenViewModel

@Composable
fun HomeScreen(uiState: State<HomeScreenViewModel.HomeScreenFeaturesListState>, navigationController: NavHostController) {

    val featuresOfCurrentPage = uiState.value.homeScreenProcessedMap
    val numberOfPages = featuresOfCurrentPage?.size
    Text(numberOfPages.toString())

}



