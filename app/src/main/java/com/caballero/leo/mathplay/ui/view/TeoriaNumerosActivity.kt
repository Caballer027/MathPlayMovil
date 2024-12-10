package com.caballero.leo.mathplay.ui.view

import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.caballero.leo.mathplay.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TeoriaNumerosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teoria_numeros)

        val btnBackClose: FloatingActionButton = findViewById(R.id.btnBackClose)
        btnBackClose.setOnClickListener {
            finish() // Cierra la actividad
        }

        val webView: WebView = findViewById(R.id.webView)
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://www.youtube.com/watch?v=M4ew1mz2UV8")

        val btnPracticar: Button = findViewById(R.id.btnPracticar)
        btnPracticar.setOnClickListener {
            startActivity(Intent(this, QuizActivity::class.java))
        }
    }
}