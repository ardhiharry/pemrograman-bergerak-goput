package com.ardhiharry.goput.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
@Entity
data class Order (

    @PrimaryKey(autoGenerate = true)
    val idOrder: Int,

    @ForeignKey(entity = User::class, parentColumns = ["idUser"], childColumns = ["customerName"])
    val customerName: Int,

    @ForeignKey(entity = Menu::class, parentColumns = ["idProduct"], childColumns = ["productOrdered"])
    val productOrdered: Int

)