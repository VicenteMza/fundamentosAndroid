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

        miboton.setOnClickListener(){
            val valorIntroducido = numeroIntroducido.text.toString().toInt()
            if (valorIntroducido >= 50) mensajeSalida.text= "El numero es mayor que 50"
            else mensajeSalida.text= "El numero es menor que 50"
        }
    }
}