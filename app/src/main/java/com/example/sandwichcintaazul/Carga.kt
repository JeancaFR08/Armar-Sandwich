package com.example.sandwichcintaazul

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Carga : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carga)

        Handler().postDelayed({
            val intent = Intent(this, Juego::class.java)
            startActivity(intent)
            finish()
        },1500)
    }
}