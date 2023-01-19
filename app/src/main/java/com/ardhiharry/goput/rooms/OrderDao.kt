package com.ardhiharry.goput.rooms

import androidx.room.*
import com.ardhiharry.goput.entities.Order

@Dao
interface OrderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addOrder(order: Order)

    @Update
    fun updateOrder(order: Order)

    @Delete
    fun deleteOrder(order: Order)

    @Transaction
    @Query("SELECT * FROM [order]")
    fun getOrders(): List<Order>

}