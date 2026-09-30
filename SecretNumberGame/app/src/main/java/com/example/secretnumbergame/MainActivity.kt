package com.example.secretnumbergame

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import kotlin.random.Random

class MainActivity : ComponentActivity() {
        private var secretNumber = 0
        private var guessCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* Set to our layout xml file */
        setContentView(R.layout.activity_main)

        val guessInput = findViewById<EditText>(R.id.guessInput)
        val guessButton = findViewById<Button>(R.id.guessButton)
        val resultText = findViewById<TextView>(R.id.resultText)
        val guessCountText = findViewById<TextView>(R.id.guessCountText)
        val playAgainButton = findViewById<Button>(R.id.playAgainButton)

        startNewGame()

        /* Action Listener for guess button */
        guessButton.setOnClickListener {

            val guessText = guessInput.text.toString()

            if (guessText.isEmpty()) {
                guessInput.error = "Enter a Number"
                return@setOnClickListener
            }

            val guess = guessText.toInt()

            if (guess < 1 || guess > 30) {
                guessInput.error = "Enter a Number between 1 - 30"
                return@setOnClickListener
            }
            guessCounter++

            guessCountText.text = "Number of guesses: $guessCounter"

            if (guess < secretNumber) {
                resultText.text = "Higher!"
            } else if (guess > secretNumber) {
                resultText.text = "Lower!"
            } else {

                resultText.text = "Correct! The Secret number was: $secretNumber"

                guessButton.isEnabled = false

                playAgainButton.visibility = View.VISIBLE
            }
            guessInput.text.clear()
        }
        /* playAgain Action Listener */
        playAgainButton.setOnClickListener {

            startNewGame()

            guessCounter = 0

            guessCountText.text = "Number of Guesses = 0"

            resultText.text = ""

            guessInput.text.clear()

            guessButton.isEnabled = true

            playAgainButton.visibility = View.GONE
        }
    }
    /* RULES */
    private fun startNewGame() {
        secretNumber = Random.nextInt(1, 31)
    }
}