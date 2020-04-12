package com.example.logicaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var correctAnswer1: String = "T";
    private var correctAnswer2: String = "F";
    private var correctAnswer3: String = "F";
    private var correctAnswer4: String = "F";
    private var correctAnswers: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews();
    }

    private fun initViews() {
        checkButton.setOnClickListener { checkAnswer() }
    }

    //check each answer and display the correct amount of answers.
    private fun checkAnswer() {
        correctAnswers = 0;
        if (editText.text.toString() == correctAnswer1) {
            correctAnswers++;
        }
        if (editText2.text.toString() == correctAnswer2) {
            correctAnswers++;
        }
        if (editText3.text.toString() == correctAnswer3) {
            correctAnswers++;
        }
        if (editText4.text.toString() == correctAnswer4) {
            correctAnswers++;
        }

        Toast.makeText(this, getString(R.string.correctNumber, correctAnswers), Toast.LENGTH_LONG)
            .show()

    }
}
