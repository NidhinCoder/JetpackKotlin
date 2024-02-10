package com.example.interviewdemo.uilayer.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.interviewdemo.datalayer.models.Feature
import com.example.interviewdemo.domainlayer.UseCase
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCase: UseCase, private val gson: Gson) :
    ViewModel() {


    var _uiState = MutableStateFlow(InterviewState())

    fun getHomeData() {
        viewModelScope.launch {
            useCase.getHomeData().collect { pageContentFromJson ->
                //Declare a ui state
                //Into the ui state add the list

                //Make a compose function
                //Implement a horizontal pager

                Log.e("Home Data", gson.toJson(pageContentFromJson))


                _uiState.update { it.copy(homePageContentMap = pageContentFromJson) }
            }
        }

    }

    data class InterviewState(var homePageContentMap: HashMap<Int,List<Feature>>? = null, var isLoading: Boolean = false)
}
