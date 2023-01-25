package com.ardhiharry.goput

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ardhiharry.goput.entities.Food
import com.ardhiharry.goput.entities.GoputDB
import com.ardhiharry.goput.entities.Order
import com.ardhiharry.goput.entities.User
import com.ardhiharry.goput.rooms.Constant
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
                    Food(textFoodAyamKremes.text.toString())
                )
                db.orderDao().addOrder(
                    Order(0, textUserAyamKremes.text.toString(), textFoodAyamKremes.text.toString(), "")
                )
                db.userDao().addUser(
                    User(textUserAyamKremes.text.toString())
                )
                finish()
            }
        }
    }
}