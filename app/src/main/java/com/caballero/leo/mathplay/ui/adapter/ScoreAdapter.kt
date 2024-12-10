package com.caballero.leo.mathplay.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.caballero.leo.mathplay.R
import com.caballero.leo.mathplay.data.model.Score

class ScoreAdapter(private var scoreList: List<Score>) : RecyclerView.Adapter<ScoreAdapter.ScoreViewHolder>() {

    class ScoreViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val xpTextView: TextView = view.findViewById(R.id.xpTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_score, parent, false)
        return ScoreViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScoreViewHolder, position: Int) {
        val score = scoreList[position]
        holder.titleTextView.text = score.title
        holder.xpTextView.text = "${score.xp} XP"
        holder.imageView.setImageResource(score.imageResId)
    }

    override fun getItemCount() = scoreList.size

    fun updateScores(scores: List<Score>) {
        this.scoreList = scores
        notifyDataSetChanged()
    }
}