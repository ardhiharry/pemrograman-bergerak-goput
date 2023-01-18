package com.ardhiharry.goput.entities

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ardhiharry.goput.rooms.CategoryDao
import com.ardhiharry.goput.rooms.OrderDao
import com.ardhiharry.goput.rooms.MenuDao
import com.ardhiharry.goput.rooms.UserDao

@Database(
    entities = [Menu::class, Category::class, User::class, Order::class],
    version = 1
)
abstract class GoputDB : RoomDatabase(){

    abstract fun productDao() : MenuDao
    abstract fun categoryDao() : CategoryDao
    abstract fun userDao() : UserDao
    abstract fun orderDao() : OrderDao

    companion object {

        @Volatile private var instance : GoputDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            GoputDB::class.java,
            "Goput777.db"
        ).build()

    }
}