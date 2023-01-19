package com.ardhiharry.goput

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ThaiTeaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thai_tea)
        supportActionBar?.hide()
    }
}