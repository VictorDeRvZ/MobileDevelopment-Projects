package com.example.higherlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_higher_lower.*

class HigherLowerActivity : AppCompatActivity() {

    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_lower)
        initViews()
    }

    //In updateUI must set the text for the last throw and the imageView with the current throw dice image (use the variables created in the previous step).
    //Create a method called initViews which will call updateUI
    //Add initViews to the onCreate
    private fun initViews() {
        higherButton.setOnClickListener {onHigherClick() }
        equalsButton.setOnClickListener {onEqualClick() }
        lowerButton.setOnClickListener {onLowerClick() }
        updateUI();

    }

    /**
     * Update the last throw text and the dice image resource drawable with the current throw.
     */

    private fun updateUI() {
        tvLastThrow.text = getString(R.string.last_throw, lastThrow)
        when (currentThrow) {
            1 -> imageView.setImageResource(R.drawable.dice1)
            2 -> imageView.setImageResource(R.drawable.dice2)
            3 -> imageView.setImageResource(R.drawable.dice3)
            4 -> imageView.setImageResource(R.drawable.dice4)
            5 -> imageView.setImageResource(R.drawable.dice5)
            6 -> imageView.setImageResource(R.drawable.dice6)
        }
    }
    //replaces previous dice value with the current one and replaces the current dice with a new dice
    // Generate random nmber between 1-6
    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    private fun checkCorect() {


    }
    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onHigherClick() {

rollDice();
      if (currentThrow > lastThrow)  {
          onAnswerCorrect()
      }
        else {
          onAnswerIncorrect()
      }
    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onLowerClick() {
        rollDice();
        if (currentThrow < lastThrow)  {
            onAnswerCorrect()
        }
        else {
            onAnswerIncorrect()
        }
    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onEqualClick() {
        rollDice();
        if (currentThrow == lastThrow)  {
onAnswerCorrect()
        }

        else {
onAnswerIncorrect()
        }
    }

    /**
     * Displays a successful Toast message.
     */
    private fun onAnswerCorrect() {
      Toast.makeText(this, getString(R.string.correct),   Toast.LENGTH_SHORT).show()
    }

    /**
     * Displays a incorrect Toast message.
     */
    private fun onAnswerIncorrect() {
        Toast.makeText(this, getString(R.string.incorrect),   Toast.LENGTH_SHORT).show()

    }



}
