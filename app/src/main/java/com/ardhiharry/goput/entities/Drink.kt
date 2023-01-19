package com.ardhiharry.goput.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Drink (

    @PrimaryKey(autoGenerate = true)
    val idDrink: Int,
    val drink: String

)