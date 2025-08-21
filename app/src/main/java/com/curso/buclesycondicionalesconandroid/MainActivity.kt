package com.curso.buclesycondicionalesconandroid

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
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
        //mensajeSalida.text = numeroAleatorio.toString()

        var intentos= 0
        fun resetGame() {
            numeroAleatorio = (1..100).random() // Generate a new random number
            intentos = 0 // Reset attempts
            numeroIntroducido.text.clear() // Clear input field
            mensajeSalida.text = "Adivina un nuevo número!" // Clear output message
        }

        miboton.setOnClickListener {
            val valorIntroducido = numeroIntroducido.text.toString().toInt()
            intentos++

            while(numeroAleatorio != valorIntroducido){

            }

            if (numeroAleatorio > valorIntroducido) mensajeSalida.text = "Más alto"
            else if (numeroAleatorio < valorIntroducido) mensajeSalida.text = "Más bajo"
            else mensajeSalida.text = "Correcto. Lo has conseguido en $intentos intentos."
        }
    }
}