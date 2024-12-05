package com.caballero.leo.mathplay.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.caballero.leo.mathplay.R
import com.caballero.leo.mathplay.databinding.FragmentHomeBinding
import com.caballero.leo.mathplay.ui.adapter.StagesAdapter
import com.caballero.leo.mathplay.ui.model.Stage

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val stages = listOf(
        Stage("Etapa 1: Números", R.drawable.numeros),
        Stage("Etapa 2: Sumas y Restas", R.drawable.sumas),
        Stage("Etapa 3: Secuencias", R.drawable.secuencias),
        Stage("Etapa 4: Geometría", R.drawable.geometria),
        Stage("Etapa 5: Fracciones", R.drawable.fracciones),
        Stage("Etapa 6: División", R.drawable.division)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        setupViewPager()
        return binding.root
    }

    private fun setupViewPager() {
        val adapter = StagesAdapter(stages) { stage ->
            Toast.makeText(context, "Explorando ${stage.title}", Toast.LENGTH_SHORT).show()
        }
        binding.viewPagerStages.adapter = adapter

        // Conecta los indicadores
        TabLayoutMediator(binding.tabLayoutIndicator, binding.viewPagerStages) { _, _ -> }.attach()
    }
}

