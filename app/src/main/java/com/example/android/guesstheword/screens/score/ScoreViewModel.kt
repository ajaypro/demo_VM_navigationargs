package com.example.android.guesstheword.screens.score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel(finalScore: Int): ViewModel() {

    private var _score = MutableLiveData<Int>()
    private var _playAgain = MutableLiveData<Boolean>()

    val score: LiveData<Int> = _score
    val playAgain: LiveData<Boolean> = _playAgain


    init {
        _score.value = finalScore
        Log.i("ScoreViewModel", "$finalScore")
    }

    fun onPlayAgain(){
        _playAgain.value = true
    }

    fun onPlayAgainComplete(){
        _playAgain.value = false
    }

}