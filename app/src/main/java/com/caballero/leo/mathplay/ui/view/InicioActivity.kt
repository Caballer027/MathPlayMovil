package com.caballero.leo.mathplay.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.caballero.leo.mathplay.R
import com.caballero.leo.mathplay.data.database.SharedPreferencesRepository

class InicioActivity : AppCompatActivity() {

    private lateinit var sharedPreferencesRepository: SharedPreferencesRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        sharedPreferencesRepository = SharedPreferencesRepository(this)

        if (sharedPreferencesRepository.isUserAuthenticated()) {
            navigateToEducationalLevel()
        }

        findViewById<Button>(R.id.buttonLogin).setOnClickListener {
            navigateToLogin()
        }

        findViewById<Button>(R.id.buttonStartLearning).setOnClickListener {
            navigateToRegister()
        }
    }

    private fun navigateToLogin() {
        val loginIntent = Intent(this, LoginActivity::class.java)
        startActivity(loginIntent)
    }

    private fun navigateToRegister() {
        val registerIntent = Intent(this, RegisterActivity::class.java)
        startActivity(registerIntent)
    }

    private fun navigateToEducationalLevel() {
        startActivity(Intent(this, EducationalLevelActivity::class.java))
        finish()
    }
}