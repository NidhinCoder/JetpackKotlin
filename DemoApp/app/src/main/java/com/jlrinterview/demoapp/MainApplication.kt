package com.jlrinterview.demoapp

import android.app.Application
import androidx.room.Room
import com.jlrinterview.demoapp.data.DemoDatabase

class MainApplication:Application() {

    companion object {
        lateinit var demoDatabase: DemoDatabase
    }
    override fun onCreate() {
        super.onCreate()
        demoDatabase = Room.databaseBuilder(
            applicationContext,
            DemoDatabase::class.java,
            DemoDatabase.NAME).build()
    }
}