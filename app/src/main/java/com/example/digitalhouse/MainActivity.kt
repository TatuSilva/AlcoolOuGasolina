package com.example.digitalhouse    

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.text.method.TextKeyListener.clear
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity() : AppCompatActivity() {

    val TAG: String = "Main Activity"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_comparar.setOnClickListener() {

            var valorGasolina = preco_gasolina.text.toString()
            var valorEtanol = preco_etanol.text.toString()
            var resultado: ImageView = findViewById<ImageView>(R.id.result)

            fun validar(): Boolean {
                if (valorEtanol.toDouble() <= 0 || valorEtanol.toDouble() <= 0) {
                    return false
                }
                return false
            }

            fun calculo(): Boolean {
                return valorEtanol.toDouble() / valorGasolina.toDouble() > 0.7
                }

            fun useEtanol() {
                return resultado.setImageResource(R.drawable.abasteca_etanol)
            }

            fun useGasolina() {
                return resultado.setImageResource(R.drawable.abasteca_gasolina)
            }

            try {
                getView().hideKeyboard()
                result.visibility = View.VISIBLE
                if (!validar()) {
                    when (calculo()){
                        true ->  useGasolina()
                        false -> useEtanol()
                    }
                }else Toast.makeText(this, "Insira valores válidos", Toast.LENGTH_LONG).show()

            } catch (ex: Exception) {
                result.visibility = View.INVISIBLE
                Toast.makeText(this, "Insira valores válidos", Toast.LENGTH_LONG).show()
            }
        }

            btn_clear.setOnClickListener() {
                try {
                    clear()
                } catch (ex: Exception) {
                    Toast.makeText(this, "Ih... Deu ruim... :/", Toast.LENGTH_LONG).show()
                }
            }


//    override fun onRestart() {
//        super.onRestart()
//        btn_comparar.setOnClickListener() {
//
//            val valorGasolina:String = preco_gasolina.text.toString()
//            val valorEtanol:String = preco_etanol.text.toString()
//            var resultado: ImageView = findViewById<ImageView>(R.id.result)
//            if (valorEtanol.toDouble() / valorGasolina.toDouble() < 0.7) {
//                resultado.setImageResource(R.drawable.abasteca_etanol)
//            } else {
//                resultado.setImageResource(R.drawable.abasteca_gasolina)
//            }
//        }
//    }
        }

        fun clear() {
            preco_etanol.text.clear()
            preco_gasolina.text.clear()
            result.visibility = View.INVISIBLE
        }

        fun View.hideKeyboard() {
            val imm =
                context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(windowToken, 0)
        }

        fun getView(): View {
            return window.decorView.findViewById(android.R.id.content)
        }
    }
