package com.caballero.leo.mathplay.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.caballero.leo.mathplay.R
import com.caballero.leo.mathplay.data.database.SharedPreferencesRepository
import com.caballero.leo.mathplay.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var sharedPreferencesRepository: SharedPreferencesRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferencesRepository = SharedPreferencesRepository(this)

        // Ajuste de insets para la pantalla completa
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configurar el botón de registro
        binding.btnRegister.setOnClickListener {
            val fullName = binding.edtFullName.text.toString().trim()
            val birthDate = binding.edtBirthDate.text.toString().trim()
            val email = binding.edtEmail.text.toString().trim()
            val password = binding.edtPassword.text.toString().trim()
            val confirmPassword = binding.edtPassword2.text.toString().trim()

            // Validaciones
            if (fullName.isEmpty()) {
                Toast.makeText(this, "Ingrese su nombre completo", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (birthDate.isEmpty()) {
                Toast.makeText(this, "Ingrese su fecha de nacimiento", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!isEmailValid(email)) {
                Toast.makeText(this, "Ingrese un correo electrónico válido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password.length < 8) {
                Toast.makeText(this, "La contraseña debe tener al menos 8 caracteres", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Registrar la información en SharedPreferences
            sharedPreferencesRepository.saveUserFullName(fullName)
            sharedPreferencesRepository.saveUserBirthDate(birthDate)
            sharedPreferencesRepository.saveUserEmail(email)
            sharedPreferencesRepository.saveUserPassword(password)
            Toast.makeText(this, "Usuario registrado con éxito", Toast.LENGTH_SHORT).show()

            // Redirigir a la actividad deseada
            val intent = Intent(this, LoginActivity::class.java) // Cambia a la actividad que desees
            startActivity(intent)
            finish()
        }

        // Configurar el botón de "Ya tengo una cuenta"
        binding.btnBackClose.setOnClickListener {
            finish()
        }
    }

    // Método para validar el formato de correo electrónico
    private fun isEmailValid(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return email.matches(emailPattern.toRegex())
    }
}