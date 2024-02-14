package com.jlrinterview.icim.cleanarchitecture.data.repositories

import com.google.gson.Gson
import com.jlrinterview.icim.cleanarchitecture.data.model.Feature
import com.jlrinterview.icim.cleanarchitecture.data.model.HomeScreenFeatureList
import com.jlrinterview.icim.cleanarchitecture.data.sampledata.HomeScreenSampleData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject


class RepositoryImpl @Inject constructor(val gson:Gson) : Repository {

    override fun getHomeScreenFeatureList(): List<Feature>? {
      val parsedData =   gson.fromJson(HomeScreenSampleData.homeScreenSampleJson,HomeScreenFeatureList::class.java)
      return  parsedData.homeScreenFeatureList
    }
}