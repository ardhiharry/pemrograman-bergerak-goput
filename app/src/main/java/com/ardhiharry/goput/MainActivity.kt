package com.ardhiharry.goput

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        btnMenuListener()
    }

    private fun btnMenuListener() {
        btnOrder.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }
    }
}