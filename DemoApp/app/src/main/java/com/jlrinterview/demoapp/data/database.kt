package com.jlrinterview.demoapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class DemoDatabase:RoomDatabase(){
    companion object {
        const val NAME = "DemoDatabase"
    }
    abstract fun getUserDao():UserDao
}