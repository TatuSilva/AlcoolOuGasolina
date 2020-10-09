package com.example.digitalhouse    

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_comparar.setOnClickListener() {
            val valorGasolina:String = preco_gasolina.text.toString()
            val valorEtanol:String = preco_etanol.text.toString()
            var resultado: ImageView = findViewById<ImageView>(R.id.result)
            if (valorEtanol.toDouble() / valorGasolina.toDouble() < 0.7) {
                resultado.setImageResource(R.drawable.abasteca_etanol)
            } else {
                resultado.setImageResource(R.drawable.abasteca_gasolina)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        btn_comparar.setOnClickListener() {

            val valorGasolina:String = preco_gasolina.text.toString()
            val valorEtanol:String = preco_etanol.text.toString()
            var resultado: ImageView = findViewById<ImageView>(R.id.result)
            if (valorEtanol.toDouble() / valorGasolina.toDouble() < 0.7) {
                resultado.setImageResource(R.drawable.abasteca_etanol)
            } else {
                resultado.setImageResource(R.drawable.abasteca_gasolina)
            }
        }
    }

    override fun onRestart() {
        super.onRestart()
        btn_comparar.setOnClickListener() {

            val valorGasolina:String = preco_gasolina.text.toString()
            val valorEtanol:String = preco_etanol.text.toString()
            var resultado: ImageView = findViewById<ImageView>(R.id.result)
            if (valorEtanol.toDouble() / valorGasolina.toDouble() < 0.7) {
                resultado.setImageResource(R.drawable.abasteca_etanol)
            } else {
                resultado.setImageResource(R.drawable.abasteca_gasolina)
            }
        }
    }
}