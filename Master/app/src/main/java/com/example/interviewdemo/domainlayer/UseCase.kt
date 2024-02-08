package com.example.interviewdemo.domainlayer

import com.example.interviewdemo.R
import com.example.interviewdemo.datalayer.Models.Feature
import com.example.interviewdemo.datalayer.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
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
    //suspend fun getHomeData(): Flow<List<Feature>>{
    suspend fun getHomeData(): Flow<HashMap<Int,List<Feature>>>{

        //return repository.getHomeData()
        val homeData =  repository.getHomeData().collect{}

        //Update the logic here 1 page 6 item. If more, then etc...
        return flowOf(hashMapOf<Int,List<Feature>>(0 to listOf(
            Feature("SEAT", R.drawable.seats), //Press Control +D for duplicates
            Feature("SEAT", R.drawable.lighting),
            Feature("SEAT", R.drawable.settings),
            Feature("SEAT", R.drawable.seats),
            Feature("SEAT", R.drawable.seats),
            Feature("SEAT", R.drawable.seats),

        ),1 to listOf(Feature("SEAT", R.drawable.seats))))



    }
}