package com.ardhiharry.goput.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User (

    @PrimaryKey(autoGenerate = true)
    val idUser: Int,
    val username: String

)