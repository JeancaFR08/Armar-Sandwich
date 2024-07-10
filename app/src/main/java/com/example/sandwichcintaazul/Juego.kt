package com.example.sandwichcintaazul

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView

class Juego : AppCompatActivity() {

    //<editor-fold desc="IMAGENES">
    lateinit var iv_11: ImageView
    lateinit var iv_12: ImageView
    lateinit var iv_13: ImageView
    lateinit var iv_14: ImageView

    lateinit var iv_21: ImageView
    lateinit var iv_22: ImageView
    lateinit var iv_23: ImageView
    lateinit var iv_24: ImageView

    lateinit var iv_31: ImageView
    lateinit var iv_32: ImageView
    lateinit var iv_33: ImageView
    lateinit var iv_34: ImageView

    lateinit var iv_checkPanArriba: ImageView
    lateinit var iv_checkPanBajo: ImageView
    lateinit var iv_checkJamon: ImageView
    lateinit var iv_checkLechuga: ImageView
    lateinit var iv_checkTomate: ImageView
    lateinit var iv_checkCebolla: ImageView
    lateinit var iv_checkMostaza: ImageView
    lateinit var iv_checkQueso: ImageView

    lateinit var iv_panArriba: ImageView
    lateinit var iv_panAbajo: ImageView
    lateinit var iv_jamon: ImageView
    lateinit var iv_lechuga: ImageView
    lateinit var iv_tomate: ImageView
    lateinit var iv_cebolla: ImageView
    lateinit var iv_mostaza: ImageView
    lateinit var iv_queso: ImageView

    lateinit var btn_swipe: Switch
    lateinit var iv_jamonsote: ImageView
    lateinit var iv_jamonGrande: ImageView
    lateinit var iv_xPepinillo: ImageView
    lateinit var iv_xSalsa: ImageView
    lateinit var iv_xMayonesa: ImageView
    lateinit var iv_xHongos: ImageView

    //</editor-fold>

    private var tv_tiempo: TextView?=null
    var tiempo = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)

        enlazar()
        cuentaAtras()
    }

    private fun cuentaAtras() {
        object : CountDownTimer(21000,1000){
            override fun onTick(millisUntilFinished: Long) {
                tiempo = (millisUntilFinished/1000).toInt()
                tv_tiempo?.setText("TIEMPO: " + tiempo + "s" )
            }

            override fun onFinish() {
                if (iv_panArriba.visibility == View.INVISIBLE && tiempo == 0){
                    derrota()
                }
            }
        }.start()
    }

    private fun derrota() {
        val intent = Intent(this, Derrota::class.java)
        startActivity(intent)
        finish()
    }

    private fun enlazar() {
        iv_11 = findViewById(R.id.iv_11)
        iv_12 = findViewById(R.id.iv_12)
        iv_13 = findViewById(R.id.iv_13)
        iv_14 = findViewById(R.id.iv_14)
        iv_21 = findViewById(R.id.iv_21)
        iv_22 = findViewById(R.id.iv_22)
        iv_23 = findViewById(R.id.iv_23)
        iv_24 = findViewById(R.id.iv_24)
        iv_31 = findViewById(R.id.iv_31)
        iv_32 = findViewById(R.id.iv_32)
        iv_33 = findViewById(R.id.iv_33)
        iv_34 = findViewById(R.id.iv_34)

        iv_checkPanArriba = findViewById(R.id.iv_checkPanArriba)
        iv_checkMostaza = findViewById(R.id.iv_checkMostaza)
        iv_checkCebolla = findViewById(R.id.iv_checkCebolla)
        iv_checkTomate = findViewById(R.id.iv_checkTomate)
        iv_checkJamon = findViewById(R.id.iv_checkJamon)
        iv_checkQueso = findViewById(R.id.iv_checkQueso)
        iv_checkLechuga = findViewById(R.id.iv_checkLechuga)
        iv_checkPanBajo = findViewById(R.id.iv_checkPanBajo)

        iv_panAbajo = findViewById(R.id.iv_panBajo)
        iv_lechuga = findViewById(R.id.iv_lechuga)
        iv_queso = findViewById(R.id.iv_queso)
        iv_jamon = findViewById(R.id.iv_jamon)
        iv_tomate = findViewById(R.id.iv_tomate)
        iv_cebolla = findViewById(R.id.iv_cebolla)
        iv_mostaza = findViewById(R.id.iv_mostaza)
        iv_panArriba = findViewById(R.id.iv_panArriba)

        iv_jamonsote = findViewById(R.id.iv_jamonsote)
        iv_jamonGrande = findViewById(R.id.iv_jamonGrande)
        btn_swipe = findViewById(R.id.btn_swipe)
        iv_xPepinillo = findViewById(R.id.iv_xPepinillo)
        iv_xSalsa = findViewById(R.id.iv_xSalsa)
        iv_xMayonesa = findViewById(R.id.iv_xMayonesa)
        iv_xHongos = findViewById(R.id.iv_xHongos)

        tv_tiempo=findViewById(R.id.tv_tiempo)
    }

    fun jamonsote(imagen: View){
        if (iv_queso.visibility == View.VISIBLE){
            btn_swipe.visibility = View.VISIBLE
            iv_jamonsote.visibility = View.VISIBLE
        }
    }

    fun validarSwitch(imagen: View) {
        if (!btn_swipe.isChecked){
            iv_jamonGrande.visibility = View.VISIBLE
            btn_swipe.visibility = View.INVISIBLE
        } else {
            iv_jamonGrande.visibility = View.VISIBLE
            btn_swipe.visibility = View.INVISIBLE
        }

        iv_jamonGrande.setOnClickListener{
            iv_jamonGrande.visibility = View.INVISIBLE
            iv_jamonsote.visibility = View.INVISIBLE

            iv_jamon.visibility = View.VISIBLE
            iv_23.visibility = View.INVISIBLE

            if (iv_jamon.visibility == View.VISIBLE){
                iv_checkJamon.visibility = View.VISIBLE
            }
        }
    }

    fun validarPanAbajo(imagen: View) {
        iv_panAbajo.visibility = View.VISIBLE
        iv_14.visibility = View.INVISIBLE

        if (iv_panAbajo.visibility == View.VISIBLE){
            iv_checkPanBajo.visibility = View.VISIBLE
        }
    }

    fun validarLechuga(imagen: View) {
        if (iv_panAbajo.visibility == View.VISIBLE){
            iv_lechuga.visibility = View.VISIBLE
            iv_22.visibility = View.INVISIBLE
        }

        if (iv_lechuga.visibility == View.VISIBLE){
            iv_checkLechuga.visibility = View.VISIBLE
        }
    }

    fun validarQueso(imagen: View) {
        if (iv_lechuga.visibility == View.VISIBLE){
            iv_queso.visibility = View.VISIBLE
            iv_12.visibility = View.INVISIBLE
        }

        if (iv_queso.visibility == View.VISIBLE){
            iv_checkQueso.visibility = View.VISIBLE
        }
    }

    fun validarTomate(imagen: View) {
        if (iv_jamon.visibility == View.VISIBLE){
            iv_tomate.visibility = View.VISIBLE
            iv_33.visibility = View.INVISIBLE
        }

        if (iv_tomate.visibility == View.VISIBLE){
            iv_checkTomate.visibility = View.VISIBLE
        }
    }

    fun validarCebolla(imagen: View) {
        if (iv_tomate.visibility == View.VISIBLE){
            iv_cebolla.visibility = View.VISIBLE
            iv_11.visibility = View.INVISIBLE
        }

        if (iv_cebolla.visibility == View.VISIBLE){
            iv_checkCebolla.visibility = View.VISIBLE
        }
    }

    fun validarMostaza(imagen: View) {
        if (iv_cebolla.visibility == View.VISIBLE){
            iv_mostaza.visibility = View.VISIBLE
            iv_24.visibility = View.INVISIBLE
        }

        if (iv_mostaza.visibility == View.VISIBLE){
            iv_checkMostaza.visibility = View.VISIBLE
        }
    }

    fun validarPanArriba(imagen: View) {
        if (iv_mostaza.visibility == View.VISIBLE){
            iv_panArriba.visibility = View.VISIBLE
            iv_32.visibility = View.INVISIBLE

            if (iv_panArriba.visibility == View.VISIBLE){
                iv_checkPanArriba.visibility = View.VISIBLE
            }

            if (tiempo >= 0 && iv_panArriba.visibility == View.VISIBLE){
                val intent = Intent(this, Victoria::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    fun validarPepinillo(imagen: View) {
        iv_xPepinillo.visibility = View.VISIBLE
        iv_xPepinillo.postDelayed({iv_xPepinillo.visibility = View.INVISIBLE}, 1000)
    }

    fun validarSalsa(imagen: View) {
        iv_xSalsa.visibility = View.VISIBLE
        iv_xSalsa.postDelayed({iv_xSalsa.visibility = View.INVISIBLE}, 1000)
    }

    fun validarMayonesa(imagen: View) {
        iv_xMayonesa.visibility = View.VISIBLE
        iv_xMayonesa.postDelayed({iv_xMayonesa.visibility = View.INVISIBLE}, 1000)
    }

    fun validarHongos(imagen: View) {
        iv_xHongos.visibility = View.VISIBLE
        iv_xHongos.postDelayed({iv_xHongos.visibility = View.INVISIBLE}, 1000)
    }

}