package com.example.android.guesstheword.screens.game

import android.icu.text.UnicodeSetSpanner
import android.os.CountDownTimer
import android.text.format.DateUtils
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    // The current word
    private var _word = MutableLiveData<String>()
    val word: LiveData<String> = _word

    // The current score
    private var _score = MutableLiveData<Int>()
    val score: LiveData<Int> = _score


    // The current game status
    private var _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish: LiveData<Boolean> = _eventGameFinish

    // Timer livedata object

    private var _currentTime = MutableLiveData<Long>()

    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>

    private var timer: CountDownTimer


    val currentTimeString = Transformations.map(_currentTime){
        DateUtils.formatElapsedTime(it)
    }

    init {
        Log.i("GameViewModel", "GameViewModel created!")

       //_word.value = ""
        _score.value = 0
        _eventGameFinish.value = false

        resetList()
        nextWord()

        timer = object : CountDownTimer(COUNTDOWN_TIME, ONE_SECOND) {

            override fun onTick(millisUntilFinished: Long) {
                _currentTime.value = millisUntilFinished / ONE_SECOND
            }

            override fun onFinish() {
                _currentTime.value = DONE
                onGameOver()
            }
        }
        timer.start()
    }

    companion object {

        // Time when the game is over
        private const val DONE = 0L

        // Countdown time interval
        private const val ONE_SECOND = 1000L

        // Total time for the game
        private const val COUNTDOWN_TIME = 60000L

    }

    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
                "queen",
                "hospital",
                "basketball",
                "cat",
                "change",
                "snail",
                "soup",
                "calendar",
                "sad",
                "desk",
                "guitar",
                "home",
                "railway",
                "zebra",
                "jelly",
                "car",
                "crow",
                "trade",
                "bag",
                "roll",
                "bubble"
        )
        wordList.shuffle()
    }

    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        if (wordList.isEmpty()) {
            resetList()
        } else {
            //Select and remove a word from the list
            _word.value = wordList.removeAt(0)
        }

    }

    /**
     * WordCount of a word and random position of word
     */

    val wordHint = Transformations.map(word){
        val randomPosition = (1..it.length).random()
        "Current word has ${it.length} letters"+
                "\n The letter at position $randomPosition is " +
                "${it[randomPosition -1].toUpperCase()}"
    }


    /** Methods for buttons presses **/

    fun onSkip() {
        if (!wordList.isEmpty()) {
            _score.value = (_score.value)?.minus(1)
        }
        nextWord()
    }

    fun onCorrect() {
        if (!wordList.isEmpty()) {
            _score.value = (_score.value)?.plus(1)
        }
        nextWord()
    }

    fun onGameOver() {
        _eventGameFinish.value = true

    }

    fun onGameFinishComplete() {
        _eventGameFinish.value = false
    }

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }
}