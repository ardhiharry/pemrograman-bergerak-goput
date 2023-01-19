package com.ardhiharry.goput.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class Order (

    @PrimaryKey(autoGenerate = true)
    val idOrder: Int,

    @ForeignKey(entity = User::class, parentColumns = ["idUser"], childColumns = ["customerName"])
    val customerName: String,

    @ForeignKey(entity = Food::class, parentColumns = ["idFood"], childColumns = ["FoodOrdered"])
    val FoodOrdered: String,

    @ForeignKey(entity = Drink::class, parentColumns = ["idDrink"], childColumns = ["DrinkOrdered"])
    val DrinkOrdered: String

)