package com.ardhiharry.goput.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Menu (

    @PrimaryKey(autoGenerate = true)
    val idMenu: Int,
    val menu: String,
    val category: String

)