package com.ardhiharry.goput

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.ardhiharry.goput.adapter.OrderAdapter
import com.ardhiharry.goput.entities.GoputDB
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

    private fun setupRecyclerView() {
        orderAdapter = OrderAdapter(arrayListOf())
        listOrder.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = orderAdapter
        }
    }
}