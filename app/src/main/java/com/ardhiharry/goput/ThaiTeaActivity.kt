package com.ardhiharry.goput

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ardhiharry.goput.entities.*
import kotlinx.android.synthetic.main.activity_ayam_kremes.*
import kotlinx.android.synthetic.main.activity_thai_tea.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ThaiTeaActivity : AppCompatActivity() {

    val db by lazy { GoputDB(this) }
    private var idOrder: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thai_tea)
        supportActionBar?.hide()
        ThaiTeaListener()
    }

    fun ThaiTeaListener() {
        btnThaiTea.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.drinkDao().addDrink(
                    Drink(0, textDrinkThaiTea.text.toString())
                )
                db.orderDao().addOrder(
                    Order(0, textUserThaiTea.text.toString(), "", textDrinkThaiTea.text.toString())
                )
                db.userDao().addUser(
                    User(0, textUserThaiTea.text.toString())
                )
                finish()
            }
        }
    }
}