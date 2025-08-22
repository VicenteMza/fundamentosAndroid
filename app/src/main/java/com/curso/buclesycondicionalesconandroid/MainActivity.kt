package com.curso.buclesycondicionalesconandroid

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    var nuevoIntento=false //flag para controlar los nuevos intentos
    var valorIntroducido=0 //almacenar valor introducido por el usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val numeroIntroducido: EditText = findViewById(R.id.entradaValor)
        val miboton: Button = findViewById(R.id.button)
        val mensajeSalida: TextView = findViewById(R.id.salidaMensaje)
        var numeroAleatorio = (1..100).random()

        var intentos= 0

        //implemetar la funcionalidad para resetar el juego
        fun resetGame() {
            numeroAleatorio = (1..100).random() // Generate a new random number
            intentos = 0 // Reset attempts
            numeroIntroducido.text.clear() // Clear input field
            mensajeSalida.text = "Adivina un nuevo número!" // Clear output message
        }

        miboton.setOnClickListener {
//            val valorIntroducido = numeroIntroducido.text.toString().toInt()
//            intentos++
//
//            if (numeroAleatorio > valorIntroducido) mensajeSalida.text = "Más alto"
//            else if (numeroAleatorio < valorIntroducido) mensajeSalida.text = "Más bajo"
//            else mensajeSalida.text = "Correcto. Lo has conseguido en $intentos intentos."
            valorIntroducido = numeroIntroducido.text.toString().toInt()
            nuevoIntento=true //marcamos que el usuario ha echo un nuevo intento

        }

        GlobalScope.launch (Dispatchers.Main){
            while (numeroAleatorio!=valorIntroducido){
                if (nuevoIntento){
                    intentos++
                    if (numeroAleatorio<valorIntroducido) mensajeSalida.text="Mas bajo"
                    else if (numeroAleatorio>valorIntroducido) mensajeSalida.text="Mas alto"

                    nuevoIntento=false //reseteara el flag de intentos
                }
                delay(500)
            }
            mensajeSalida.text="lo has consiguido en $intentos intentos"
        }
    }
}