package com.jlrinterview.x3

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.Room
import androidx.room.RoomDatabase

data class User(
    val username: String,
    val password: String,
    val phoneNumber: String
)

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: User)
}

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract val userDao: UserDao

    companion object {
        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getInstance(context: Context): UserDatabase
        {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "user_database"

                    ).build()
                    INSTANCE = instance
                }
                return instance

            }
        }
    }
}

