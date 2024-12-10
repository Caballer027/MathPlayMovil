package com.caballero.leo.mathplay.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.caballero.leo.mathplay.R
import com.caballero.leo.mathplay.data.model.Medal
import com.caballero.leo.mathplay.data.model.Score

class ScoreViewModel : ViewModel() {

    val scoreList = MutableLiveData<List<Score>>()
    val medalList = MutableLiveData<List<Medal>>()

    fun getScores() {
        val scores = listOf(
            Score("Números", 150, R.drawable.medalla),
            Score("Sumas y Restas", 0, R.drawable.puntaje)
        )
        scoreList.postValue(scores)
    }

    fun getMedals() {
        val medals = listOf(
            Medal("Números", "Completado", 150, R.drawable.medalla),
            Medal("Sumas y Restas", "No Completado", 0, R.drawable.puntaje)
        )
        medalList.postValue(medals)
    }
}