package com.caballero.leo.mathplay.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.caballero.leo.mathplay.databinding.ActivityPrimariaBinding
import com.caballero.leo.mathplay.ui.MainActivity

class PrimariaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPrimariaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrimariaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Lógica del botón de retroceso
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
            // Verificar si el RadioButton "1° Grado" está seleccionado
            val selectedId = binding.radioGroup.checkedRadioButtonId
            if (selectedId == binding.radio1.id) {
                // Si "1° Grado" está seleccionado, navegar a MainActivity
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                // Aquí puedes agregar lógica para otros grados si es necesario
                // Por ejemplo, mostrar un mensaje o realizar otra acción
            }
        }
    }
}