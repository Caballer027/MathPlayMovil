package com.caballero.leo.mathplay.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.caballero.leo.mathplay.R
import com.caballero.leo.mathplay.ui.MainActivity
import kotlin.random.Random

class QuizActivity : AppCompatActivity() {

    private val numeros = (1..10).toList()
    private var vidas = 3
    private var puntaje = 0
    private var numeroActual = 0
    private var respuestaCorrecta = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val tvNumeroActual: TextView = findViewById(R.id.tvNumeroActual)
        val tvResultado: TextView = findViewById(R.id.tvResultado)
        val btnPar: Button = findViewById(R.id.btnPar)
        val btnImpar: Button = findViewById(R.id.btnImpar)
        val btnHome: Button = findViewById(R.id.btnHome)

        generarNumero(tvNumeroActual)

        btnPar.setOnClickListener { verificarRespuesta("par", tvNumeroActual, tvResultado, btnHome) }
        btnImpar.setOnClickListener { verificarRespuesta("impar", tvNumeroActual, tvResultado, btnHome) }

        btnHome.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun generarNumero(tvNumeroActual: TextView) {
        numeroActual = numeros.random()
        respuestaCorrecta = if (numeroActual % 2 == 0) "par" else "impar"
        tvNumeroActual.text = "Número: $numeroActual"
    }

    private fun verificarRespuesta(respuesta: String, tvNumeroActual: TextView, tvResultado: TextView, btnHome: Button) {
        if (respuesta == respuestaCorrecta) {
            puntaje++
            tvResultado.text = "¡Correcto! Puntaje: $puntaje"
        } else {
            vidas--
            tvResultado.text = "Incorrecto. Vidas restantes: $vidas"
        }

        if (vidas == 0 || puntaje == 5) {
            tvResultado.text = "Juego Terminado. Puntaje Final: $puntaje"
            btnHome.visibility = Button.VISIBLE
            Toast.makeText(this, "¡Felicidades! Has completado el juego.", Toast.LENGTH_LONG).show()
        } else {
            generarNumero(tvNumeroActual)
        }
    }
}