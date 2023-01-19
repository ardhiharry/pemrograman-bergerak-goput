package com.ardhiharry.goput

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ardhiharry.goput.entities.Food
import com.ardhiharry.goput.entities.GoputDB
import com.ardhiharry.goput.entities.Order
import com.ardhiharry.goput.entities.User
import kotlinx.android.synthetic.main.activity_ayam_kremes.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AyamKremesActivity : AppCompatActivity() {

    val db by lazy { GoputDB(this) }
    private var idOrder: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayam_kremes)
        supportActionBar?.hide()
        AyamKremesListener()
    }

    fun AyamKremesListener() {
        btnAyamKremesOrder.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.foodDao().addFood(
                    Food(0, "Ayam Kremes")
                )
                db.orderDao().addOrder(
                    Order(0, textUser.text.toString(), textFood.text.toString(), "")
                )
                db.userDao().addUser(
                    User(0, textUser.text.toString())
                )
                finish()
            }
        }
    }
}