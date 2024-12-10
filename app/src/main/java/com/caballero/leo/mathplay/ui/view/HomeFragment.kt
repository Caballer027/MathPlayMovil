package com.caballero.leo.mathplay.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.caballero.leo.mathplay.R
import com.caballero.leo.mathplay.data.model.Card
import com.caballero.leo.mathplay.ui.adapter.CardAdapter

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CardAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val cards = listOf(
            Card("Números", R.drawable.numeros),
            Card("Sumas y Restas", R.drawable.sumas_restas),
            Card("Secuencias", R.drawable.secuencias),
            Card("Geometría", R.drawable.geometria),
            Card("Fracciones", R.drawable.fraccion),
            Card("División", R.drawable.division)
        )

        adapter = CardAdapter(cards, requireContext())
        recyclerView.adapter = adapter

        return view
    }
}