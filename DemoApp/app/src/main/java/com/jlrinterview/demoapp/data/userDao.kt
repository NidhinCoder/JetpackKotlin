package com.jlrinterview.demoapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

       @Query("Select * from users")
       fun getAllUsers() :LiveData<List<User>>

       @Insert
       fun addUser(user:User)

       @Query("Delete from users where userId=:id")
       fun deleteUser(id:Int)


}