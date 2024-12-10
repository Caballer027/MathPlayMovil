package com.caballero.leo.mathplay.ui.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.rommansabbir.animationx.Attention
import com.rommansabbir.animationx.animationXAttention
import com.caballero.leo.mathplay.databinding.ActivitySplashBinding
import com.caballero.leo.mathplay.data.database.SharedPreferencesRepository

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private lateinit var sharedPreferencesRepository: SharedPreferencesRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferencesRepository = SharedPreferencesRepository(this)

        enableEdgeToEdge()
        showAnimationLogo()
        runPostDelayed()
    }

    private fun showAnimationLogo() {
        Handler(Looper.getMainLooper()).postDelayed({
            binding.imvLogo.animationXAttention(Attention.ATTENTION_RUBERBAND)
        }, 1000)
    }

    private fun runPostDelayed() {
        Handler(Looper.getMainLooper()).postDelayed({
            navigateNextActivity()
        }, 5000)
    }

    private fun navigateNextActivity() {
        val nextActivity = if (sharedPreferencesRepository.isUserAuthenticated()) {
            EducationalLevelActivity::class.java
        } else {
            InicioActivity::class.java
        }
        startActivity(Intent(this, nextActivity))
        finish()
    }
}