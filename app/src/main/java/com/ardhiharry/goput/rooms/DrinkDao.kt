package com.ardhiharry.goput.rooms

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.ardhiharry.goput.entities.Drink

@Dao
interface DrinkDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addDrink(drink: Drink)

}