package com.jlrinterview.demoapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    var userId: Int = 0,

    var username: String,
    var password: String,
    var email: String,
    var phoneNumber: String
)