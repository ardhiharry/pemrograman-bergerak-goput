package com.ardhiharry.goput

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SusuSodaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_susu_soda)
        supportActionBar?.hide()
    }
}