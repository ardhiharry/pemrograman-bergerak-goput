package com.ardhiharry.goput.rooms

import androidx.room.*
import com.ardhiharry.goput.entities.Order
import com.ardhiharry.goput.entities.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(user: User)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("SELECT * FROM user")
    fun getUsers(): List<User>

    @Query("SELECT * FROM user WHERE username=:username")
    fun getUser(username: String): List<User>

}