package com.caballero.leo.mathplay.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.caballero.leo.mathplay.R
import com.caballero.leo.mathplay.data.model.Medal

class MedalAdapter(private var medalList: List<Medal>) : RecyclerView.Adapter<MedalAdapter.MedalViewHolder>() {

    class MedalViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val statusTextView: TextView = view.findViewById(R.id.statusTextView)
        val xpTextView: TextView = view.findViewById(R.id.xpTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_medal, parent, false)
        return MedalViewHolder(view)
    }

    override fun onBindViewHolder(holder: MedalViewHolder, position: Int) {
        val medal = medalList[position]
        holder.titleTextView.text = medal.title
        holder.statusTextView.text = medal.status
        holder.xpTextView.text = "${medal.xp} XP"
        holder.imageView.setImageResource(medal.imageResId)
    }

    override fun getItemCount() = medalList.size

    fun updateMedals(medals: List<Medal>) {
        this.medalList = medals
        notifyDataSetChanged()
    }
}