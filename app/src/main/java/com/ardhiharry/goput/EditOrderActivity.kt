package com.ardhiharry.goput

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ardhiharry.goput.entities.Food
import com.ardhiharry.goput.entities.GoputDB
import com.ardhiharry.goput.entities.Order
import com.ardhiharry.goput.entities.User
import com.ardhiharry.goput.rooms.Constant
import kotlinx.android.synthetic.main.activity_ayam_kremes.*
import kotlinx.android.synthetic.main.activity_edit_order.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditOrderActivity : AppCompatActivity() {

    val db by lazy { GoputDB(this) }
    private var idOrder: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_order)
        supportActionBar?.hide()
        setupView()
    }

    fun setupView() {
        val intentType = intent.getIntExtra("intent_type", 0)
        when (intentType) {
            Constant.TYPE_READ -> {
                button_update.visibility = View.GONE
                getOrder()
            }
        }
    }

    fun getOrder() {
        idOrder = intent.getIntExtra("intent_id", 0)
        CoroutineScope(Dispatchers.IO).launch {
            val orders = db.orderDao().getOrder( idOrder )[0]
            edit_customer_name.setText( orders.customerName )
        }
    }
}