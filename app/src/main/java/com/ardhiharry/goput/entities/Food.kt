package com.ardhiharry.goput.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Food (

    @PrimaryKey(autoGenerate = false)
//    val idFood: Int,
    val food: String

)