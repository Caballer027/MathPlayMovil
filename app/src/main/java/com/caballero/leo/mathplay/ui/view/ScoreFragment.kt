package com.caballero.leo.mathplay.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.caballero.leo.mathplay.databinding.FragmentScoreBinding
import com.caballero.leo.mathplay.ui.adapter.MedalAdapter
import com.caballero.leo.mathplay.ui.adapter.ScoreAdapter
import com.caballero.leo.mathplay.ui.viewmodel.ScoreViewModel

class ScoreFragment : Fragment() {

    private val scoreViewModel: ScoreViewModel by viewModels()

    private lateinit var binding: FragmentScoreBinding

    private val scoreAdapter by lazy { ScoreAdapter(emptyList()) }
    private val medalAdapter by lazy { MedalAdapter(emptyList()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvScores.adapter = scoreAdapter
        binding.rvMedals.adapter = medalAdapter

        scoreViewModel.getScores()
        scoreViewModel.getMedals()

        scoreViewModel.scoreList.observe(viewLifecycleOwner) {
            scoreAdapter.updateScores(it)
        }

        scoreViewModel.medalList.observe(viewLifecycleOwner) {
            medalAdapter.updateMedals(it)
        }
    }
}