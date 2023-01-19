package com.ardhiharry.goput

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.ardhiharry.goput.adapter.OrderAdapter
import com.ardhiharry.goput.entities.GoputDB
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_order.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        btnMenuListener()
        btnListOrderListener()
    }

    private fun btnMenuListener() {
        btnMenu.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }
    }

    private fun btnListOrderListener() {
        btnListOrder.setOnClickListener {
            startActivity(Intent(this, OrderActivity::class.java))
        }
    }


}