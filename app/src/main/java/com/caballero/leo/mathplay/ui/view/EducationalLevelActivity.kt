package com.caballero.leo.mathplay.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.caballero.leo.mathplay.databinding.ActivityNivelEducativoBinding

class EducationalLevelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNivelEducativoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNivelEducativoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        binding.imInicial.setOnClickListener {
            startActivity(Intent(this, InicialActivity::class.java))
        }

        binding.imPrimaria.setOnClickListener {
            startActivity(Intent(this, PrimariaActivity::class.java))
        }

        binding.imSecundaria.setOnClickListener {
            startActivity(Intent(this, SecundariaActivity::class.java))
        }
    }
}