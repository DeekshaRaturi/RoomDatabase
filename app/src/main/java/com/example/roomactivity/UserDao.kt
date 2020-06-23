package com.example.roomactivity

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

  @Insert
  fun saveUser(user: User)

  @Query("select * from User")
  fun getUser(): List<User>


}