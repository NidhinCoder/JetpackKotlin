package com.example.interviewdemo.uilayer.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.interviewdemo.datalayer.Repository
import com.example.interviewdemo.domainlayer.UseCase
import com.google.gson.Gson
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val useCase: UseCase, private val gson: Gson) :
    ViewModel() {

    fun getHomeData() {
        viewModelScope.launch {
            useCase.getHomeData().collect {features->
                //Declare a ui state
                //Into the ui state add the list

                //Make a compose function
                //Implement a horizontal pager

                Log.e("Home Data", gson.toJson(features))
            }
        }


    }
}