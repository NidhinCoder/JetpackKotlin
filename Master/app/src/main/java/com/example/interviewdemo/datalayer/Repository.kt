package com.example.interviewdemo.datalayer

import com.example.interviewdemo.datalayer.Models.Feature
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getHomeData(): Flow<List<Feature>>
}
