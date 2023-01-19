package com.ardhiharry.goput.rooms

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.ardhiharry.goput.entities.Food

@Dao
interface FoodDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addFood(food: Food)

}