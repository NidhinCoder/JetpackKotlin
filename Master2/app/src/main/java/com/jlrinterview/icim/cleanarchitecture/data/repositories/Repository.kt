package com.jlrinterview.icim.cleanarchitecture.data.repositories

import com.jlrinterview.icim.cleanarchitecture.data.model.Feature
import kotlinx.coroutines.flow.Flow

/*
* A stream of data that can be computed asynchronously is conceptually
* referred to as a Flow. It is constructed using Coroutines. An appropriate
* Kotlin type for modeling data streams is Flow.
* */

interface Repository {
    fun getHomeScreenFeatureList(): List<Feature>?
}