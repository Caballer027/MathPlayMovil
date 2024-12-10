package com.caballero.leo.mathplay.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.caballero.leo.mathplay.databinding.ActivityLoginBinding
import com.caballero.leo.mathplay.ui.viewmodel.LoginViewModel
import com.caballero.leo.mathplay.data.database.SharedPreferencesRepository

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPreferencesRepository: SharedPreferencesRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferencesRepository = SharedPreferencesRepository(this)

        loginViewModel = LoginViewModel(this)
        observeValues()

        binding.btnBackClose.setOnClickListener {
            navigateToInicio()
        }

        binding.btnLogin.setOnClickListener {
            loginViewModel.validateInputs(
                email = binding.edtEmail.text.toString(),
                password = binding.edtPassword.text.toString()
            )
        }
    }

    private fun observeValues() {
        loginViewModel.inputsError.observe(this) {
            Toast.makeText(this, "Ingrese los datos completos", Toast.LENGTH_SHORT).show()
        }

        loginViewModel.authError.observe(this) {
            Toast.makeText(this, "Error usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
        }

        loginViewModel.registerError.observe(this) {
            Toast.makeText(this, "Usuario no registrado", Toast.LENGTH_SHORT).show()
        }

        loginViewModel.loginSuccess.observe(this) {
            sharedPreferencesRepository.setUserAuthenticated(true)
            navigateToEducationalLevel()
        }
    }

    private fun navigateToEducationalLevel() {
        startActivity(Intent(this, EducationalLevelActivity::class.java))
        finish()
    }

    private fun navigateToInicio() {
        startActivity(Intent(this, InicioActivity::class.java))
        finish()
    }
}