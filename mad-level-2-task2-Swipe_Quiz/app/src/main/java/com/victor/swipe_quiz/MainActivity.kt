package com.victor.swipe_quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val questions = arrayListOf<Question>(
        Question("Ostriches bury their heads up to 18 inches in the sand.", false),
        Question("Louis Braille, creator of the Braille system of writing for the blind, was himself blind.", true),
        Question("According to the Declaration of Independence, the people \"have nothing to lose but their chains.\"", false),
        Question("The Oscar-winning film Guess Who's Coming to Dinner (1967) deals with interracial marriage.", true),
        Question("Flight recorders onboard planes are painted black boxes.",false),
        Question("The \"China Syndrome\" is what hostages experience when they begin to feel empathy for their captors.",false),
        Question("A penny dropped from a tall building can reach sufficient velocity to kill a pedestrian below.",false),
        Question("Harry Potter's archenemy is Tom Marvolo Riddle.",true),
        Question("Other than water, coffee is the world's most popular drink.", true)
    )
    private val questionAdapter = QuestionAdapter(questions)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }


    private fun initViews() {
        rvQuestions.layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        rvQuestions.adapter = questionAdapter
        rvQuestions.addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))

    }

}
