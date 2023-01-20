package com.ardhiharry.goput.rooms

import androidx.room.*
import com.ardhiharry.goput.entities.Order

@Dao
interface OrderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addOrder(order: Order)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateOrder(order: Order)

    @Delete
    fun deleteOrder(order: Order)

    @Query("SELECT * FROM [order]")
    fun getOrders(): List<Order>

    @Query("SELECT * FROM [order] WHERE idOrder=:id_order")
    fun getOrder(id_order: Int): List<Order>

}