package com.caballero.leo.mathplay.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.caballero.leo.mathplay.R
import com.caballero.leo.mathplay.data.model.Card
import com.caballero.leo.mathplay.ui.view.*

class CardAdapter(private val cardList: List<Card>, private val context: Context) :
    RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    class CardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val exploreButton: Button = view.findViewById(R.id.exploreButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = cardList[position]
        holder.titleTextView.text = card.title
        holder.imageView.setImageResource(card.imageResId)

        holder.exploreButton.setOnClickListener {
            val intent = when (card.title) {
                "Números" -> Intent(context, TeoriaNumerosActivity::class.java)
                "Sumas y Restas" -> Intent(context, TeoriaSumasRestasActivity::class.java)
                "Secuencias" -> Intent(context, TeoriaSecuenciasActivity::class.java)
                "Geometría" -> Intent(context, TeoriaGeometriaActivity::class.java)
                "Fracciones" -> Intent(context, TeoriaFraccionesActivity::class.java)
                "División" -> Intent(context, TeoriaDivisionActivity::class.java)
                else -> null
            }
            intent?.let { context.startActivity(it) }
        }
    }

    override fun getItemCount() = cardList.size
}