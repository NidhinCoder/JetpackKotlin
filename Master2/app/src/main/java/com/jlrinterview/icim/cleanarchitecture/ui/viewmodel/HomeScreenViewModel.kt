package com.jlrinterview.icim.cleanarchitecture.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jlrinterview.icim.cleanarchitecture.data.model.Feature
import com.jlrinterview.icim.cleanarchitecture.domain.UseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel(val useCase: UseCase) : ViewModel() {

    data class HomeScreenFeaturesListState(var homeScreenProcessedMap: HashMap<Int, List<Feature>>? = null)

    var uiHomeScreenState = MutableStateFlow(HomeScreenFeaturesListState())

    fun getHomeScreenData() {
        viewModelScope.launch {
            useCase.getHomeScreenFeatureList().collect { wholeListOfFeatures ->
                uiHomeScreenState.update {
                    it.copy(homeScreenProcessedMap = wholeListOfFeatures)
                }
            }
        }
    }

}