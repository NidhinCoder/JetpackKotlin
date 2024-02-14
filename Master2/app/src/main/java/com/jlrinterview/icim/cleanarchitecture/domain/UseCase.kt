package com.jlrinterview.icim.cleanarchitecture.domain

import com.jlrinterview.icim.cleanarchitecture.data.model.Feature
import com.jlrinterview.icim.cleanarchitecture.data.repositories.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject


class UseCase @Inject constructor (val repository:Repository) {

    fun getHomeScreenFeatureList(): Flow<HashMap<Int, List<Feature>>> {

        //Get the feature list from repository
        val homeScreenFeatureList = repository.getHomeScreenFeatureList()

         //If I have more than 6 items, I will introduce a new page
        var page = 0
        var itemCount = 0
        val homeScreenProcessedMap = HashMap<Int, List<Feature>>()
        var test = mutableListOf<Feature>()

        homeScreenFeatureList?.forEach { feature: Feature ->
            test.add(feature)
            itemCount++
           if(itemCount==6){
               itemCount = 0
               homeScreenProcessedMap[page]=test
               page+=1
               test = mutableListOf<Feature>()
           }
        }
        return flowOf(homeScreenProcessedMap)
    }
}