package com.ardhiharry.goput

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ayam_kremes.*
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        supportActionBar?.hide()
        btnAyamKremesListener()
        btnSotoAyamListener()
        btnRujakLontongListener()
        btnSusuSodaListener()
        btnThaiTeaListener()
    }

    private fun btnAyamKremesListener() {
        btn_Ayam_Kremes.setOnClickListener {
            startActivity(Intent(this, AyamKremesActivity::class.java))
        }
    }

    private fun btnSotoAyamListener() {
        btn_Soto_Ayam.setOnClickListener {
            startActivity(Intent(this, SotoAyamActivity::class.java))
        }
    }

    private fun btnRujakLontongListener() {
        btn_Rujak_Lontong.setOnClickListener {
            startActivity(Intent(this, RujakLontongActivity::class.java))
        }
    }

    private fun btnSusuSodaListener() {
        btn_Susu_Soda.setOnClickListener {
            startActivity(Intent(this, SusuSodaActivity::class.java))
        }
    }

    private fun btnThaiTeaListener() {
        btn_Thai_Tea.setOnClickListener {
            startActivity(Intent(this, ThaiTeaActivity::class.java))
        }
    }
}