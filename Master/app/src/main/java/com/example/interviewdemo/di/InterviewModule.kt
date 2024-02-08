package com.example.interviewdemo.di

import com.example.interviewdemo.datalayer.Repository
import com.example.interviewdemo.datalayer.RepositoryImpl
import com.example.interviewdemo.domainlayer.UseCase
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*
Hilt modules
Sometimes a type cannot be constructor-injected. This can happen for multiple reasons. For example, you cannot constructor-inject an interface. You also cannot constructor-inject a type that you do not own, such as a class from an external library. In these cases, you can provide Hilt with binding information by using Hilt modules.

A Hilt module is a class that is annotated with @Module. Like a Dagger module, it informs Hilt how to provide instances of certain types. Unlike Dagger modules, you must annotate Hilt modules with @InstallIn to tell Hilt which Android class each module will be used or installed in.
 */
@Module
@InstallIn(SingletonComponent::class)
object InterviewModule {

    //This can be accessed anywhere in the project through DI
    @Singleton
    @Provides
    fun gsonHomeDataProvider(): Gson {
        return Gson()
    }

    @Provides
    fun repositoryProvider(gson:Gson): Repository
    {
        return RepositoryImpl(gson)
    }

    @Provides
    fun useCaseProvider(repository: Repository):UseCase
    {
        return UseCase(repository)
    }

}