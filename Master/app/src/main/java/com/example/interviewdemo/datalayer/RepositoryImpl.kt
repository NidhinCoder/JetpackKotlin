package com.example.interviewdemo.datalayer

import com.example.interviewdemo.datalayer.Models.Feature
import com.example.interviewdemo.datalayer.Models.FeatureRecords
import com.example.interviewdemo.utilities.HomeFeaturesStub
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val gson: Gson) : Repository {


    /*
    A flow is very similar to an Iterator that
    produces a sequence of values, but it uses
    suspend functions to produce and consume values
    asynchronously. This means, for example, that
    the flow can safely make a network request to
    produce the next value without blocking the main
    thread.
    * */
    override fun getHomeData(): Flow<List<Feature>> {
            val homeData = gson.fromJson(HomeFeaturesStub.homeDataJson,FeatureRecords::class.java)

            //ASSERTING THAT records will not be null. If so , application will crash
            return flowOf(homeData.records!!)
    }
}
