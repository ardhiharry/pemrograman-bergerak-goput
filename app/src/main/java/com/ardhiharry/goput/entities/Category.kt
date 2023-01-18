package com.ardhiharry.goput.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Category (

    @PrimaryKey(autoGenerate = true)
    val idCategory: Byte,
    val category: String

)