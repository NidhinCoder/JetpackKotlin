package com.example.interviewdemo.domainlayer

import com.example.interviewdemo.datalayer.Models.Feature
import com.example.interviewdemo.datalayer.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


//Constructor injection
class UseCase @Inject constructor(private val repository: Repository) {

    //It will be accessed from repository
    //Business logic can be added here
//    override fun getHomeData(): Flow<List<Feature>> {
//        TODO("Not yet implemented")
//    }

    //Method 1
    //fun getHomeData() =  repository.getHomeData()

    //In case if business logic
    fun getHomeData(): Flow<List<Feature>>{
        return repository.getHomeData()
    }
}