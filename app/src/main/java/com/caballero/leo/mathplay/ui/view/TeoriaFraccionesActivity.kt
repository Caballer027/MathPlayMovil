package com.caballero.leo.mathplay.ui.view

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.caballero.leo.mathplay.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TeoriaFraccionesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teoria_fracciones)

        val btnBackClose: FloatingActionButton = findViewById(R.id.btnBackClose)
        btnBackClose.setOnClickListener {
            finish() // Cierra la actividad
        }

        val webView: WebView = findViewById(R.id.webView)
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://www.youtube.com/embed/VIDEO_ID") // Reemplaza VIDEO_ID con el ID real del video
    }
}