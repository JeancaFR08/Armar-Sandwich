package com.example.sandwichcintaazul

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var iv_inicio: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iniciar()
    }

    private fun iniciar() {
        iv_inicio = findViewById(R.id.iv_inicio)
    }

    fun pantallaCarga(imagen:View){
        var intent = Intent(this, Carga::class.java)
        startActivity(intent)
        finish()
    }
}