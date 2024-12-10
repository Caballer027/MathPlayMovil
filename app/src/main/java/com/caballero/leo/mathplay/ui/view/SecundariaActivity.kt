package com.caballero.leo.mathplay.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.caballero.leo.mathplay.databinding.ActivitySecundariaBinding

class SecundariaActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecundariaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecundariaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configura el botón de retroceso
        binding.btnBackClose.setOnClickListener {
            finish() // Cierra la actividad y vuelve a la anterior
        }
        // Lógica para habilitar el botón "CONTINUAR"
        binding.radioGroup.setOnCheckedChangeListener { _, _ ->
            // Cuando se selecciona un RadioButton, habilita el botón "CONTINUAR"
            binding.btnContinuar.isEnabled = true
        }

        // Lógica para el botón "CONTINUAR"
        binding.btnContinuar.setOnClickListener {
            // Aquí puedes agregar la lógica que deseas ejecutar al presionar "CONTINUAR"
        }
    }
}