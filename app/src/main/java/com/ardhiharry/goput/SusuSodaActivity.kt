package com.ardhiharry.goput

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ardhiharry.goput.entities.*
import kotlinx.android.synthetic.main.activity_ayam_kremes.*
import kotlinx.android.synthetic.main.activity_susu_soda.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SusuSodaActivity : AppCompatActivity() {

    val db by lazy { GoputDB(this) }
    private var idOrder: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_susu_soda)
        supportActionBar?.hide()
        SusuSodaListener()
    }

    fun SusuSodaListener() {
        btnSusuSoda.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.drinkDao().addDrink(
                    Drink(0, textDrinkSusuSoda.text.toString())
                )
                db.orderDao().addOrder(
                    Order(0, textUserSusuSoda.text.toString(), "", textDrinkSusuSoda.text.toString())
                )
                db.userDao().addUser(
                    User(0, textUserSusuSoda.text.toString())
                )
                finish()
            }
        }
    }
}