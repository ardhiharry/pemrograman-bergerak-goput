package com.ardhiharry.goput.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class Order (

    @PrimaryKey(autoGenerate = true)
    val idOrder: Int,

    @ForeignKey(entity = User::class, parentColumns = ["username"], childColumns = ["customerName"])
    val customerName: String,

    @ForeignKey(entity = Food::class, parentColumns = ["food"], childColumns = ["FoodOrdered"])
    val FoodOrdered: String,

    @ForeignKey(entity = Drink::class, parentColumns = ["drink"], childColumns = ["DrinkOrdered"])
    val DrinkOrdered: String

)