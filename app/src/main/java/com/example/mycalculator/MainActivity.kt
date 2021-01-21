package com.example.mycalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    var stringaNumeroDigitato = ""
    var primoOperatore = 0.0
    var secondoOperatore = 0.0
    var segno = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun scriviNumero(v: View) {
        val b = v as Button
        stringaNumeroDigitato += b.text.toString()
        numberText.text = stringaNumeroDigitato
    }
    fun detectOperator(v: View) {
        numberText.text = resources.getString(R.string.DefaultNumber)
        primoOperatore = stringaNumeroDigitato.toDouble()
        stringaNumeroDigitato = ""
        val b = v as Button
        segno = b.text.toString()
    }
    fun cancella(v: View) {
        stringaNumeroDigitato = ""
        primoOperatore = 0.0
        secondoOperatore = 0.0
        numberText.text = resources.getString(R.string.DefaultNumber)
    }
    fun makeOperation(v: View) {
        secondoOperatore = stringaNumeroDigitato.toDouble()
        when(segno) {
            "+" -> {
                numberText.text = (primoOperatore + secondoOperatore).toString()
            }
            "-" -> {
                numberText.text = (primoOperatore - secondoOperatore).toString()
            }
            "*" -> {
                numberText.text = (primoOperatore * secondoOperatore).toString()
            }
            "/" -> {
                numberText.text = (primoOperatore / secondoOperatore).toString()
            }
        }
    }
}