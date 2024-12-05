package com.caballero.leo.mathplay.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.caballero.leo.mathplay.R
import com.caballero.leo.mathplay.databinding.StageCardBinding
import com.caballero.leo.mathplay.ui.model.Stage

class StagesAdapter(private val stages: List<Stage>, private val onClick: (Stage) -> Unit) :
    RecyclerView.Adapter<StagesAdapter.StageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.stage_card, parent, false)
        return StageViewHolder(view)
    }

    override fun onBindViewHolder(holder: StageViewHolder, position: Int) {
        val stage = stages[position]
        holder.bind(stage, onClick)
    }

    override fun getItemCount(): Int = stages.size

    class StageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = StageCardBinding.bind(itemView)

        fun bind(stage: Stage, onClick: (Stage) -> Unit) = with(binding) {
            ivStageImage.setImageResource(stage.imageRes)
            tvStageTitle.text = stage.title
            btnExplore.setOnClickListener { onClick(stage) }
        }
    }
}
