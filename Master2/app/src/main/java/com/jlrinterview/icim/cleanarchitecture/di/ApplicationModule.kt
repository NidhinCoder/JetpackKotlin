package com.jlrinterview.icim.cleanarchitecture.di


import com.google.gson.Gson
import com.jlrinterview.icim.cleanarchitecture.data.repositories.Repository
import com.jlrinterview.icim.cleanarchitecture.data.repositories.RepositoryImpl
import com.jlrinterview.icim.cleanarchitecture.domain.UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Singleton
    @Provides
    fun repositoryProvider(gson:Gson):Repository {
        return RepositoryImpl(gson)
    }
    fun useCaseProvider(repository:Repository):UseCase {
        return UseCase(repository)
    }

}