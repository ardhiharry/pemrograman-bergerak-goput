package com.ardhiharry.goput.rooms

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.ardhiharry.goput.entities.Order

@Dao
interface OrderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addOrder(order: Order)

    @Update
    fun updateOrder(order: Order)

    @Delete
    fun deleteOrder(order: Order)

//    @Query("SELECT * FROM order")
//    fun getUsers(): List<Order>

//    @Transaction
//    @Query("SELECT * FROM order WHERE idOrder = idOrder")
//    fun getOrder(idOrder: Int): List<Order>

}