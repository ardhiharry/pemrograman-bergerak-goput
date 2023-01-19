package com.ardhiharry.goput

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.ardhiharry.goput.adapter.OrderAdapter
import com.ardhiharry.goput.entities.GoputDB
import com.ardhiharry.goput.entities.Order
import com.ardhiharry.goput.rooms.Constant
import kotlinx.android.synthetic.main.activity_order.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class OrderActivity : AppCompatActivity() {

    val db by lazy { GoputDB(this) }
    lateinit var orderAdapter: OrderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        supportActionBar?.hide()
        setupRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        CoroutineScope(Dispatchers.IO).launch {
            val orders = db.orderDao().getOrders()
            Log.d("MainActivity", "dbResponse: $orders")
            withContext(Dispatchers.Main) {
                orderAdapter.setData( orders )
            }
        }
    }

    fun intentEdit(idOrder: Int, intentType: Int) {
        startActivity(
            Intent(applicationContext, EditOrderActivity::class.java)
                .putExtra("intent_id", idOrder)
                .putExtra("intent_type", intentType)
        )
    }

    private fun setupRecyclerView() {
        orderAdapter = OrderAdapter(arrayListOf(), object : OrderAdapter.OnAdapterListener {
            override fun onClick(order: Order) {
                intentEdit(order.idOrder, Constant.TYPE_READ)
            }

        })
        listOrder.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = orderAdapter
        }
    }
}