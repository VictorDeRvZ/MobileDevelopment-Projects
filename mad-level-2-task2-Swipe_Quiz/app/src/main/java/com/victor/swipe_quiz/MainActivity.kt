package com.victor.swipe_quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val questions = arrayListOf<Question>(
        Question("The Ctrl-Z is better than a time machine..", false),
        Question("The first computer “bug” was identified in1947 as a dead moth.", true),
        Question("APIs are like stars, once a class is there everybody will assume it will always be there..\"", false),
        Question("The first computer was actually a loom called the Jacquard loom, an automated, mechanical loom, which didn’t use any electricity.", true),
        Question("The language name C because it succeeds another language called B.",false),
        Question("Ctrl + C and Ctrl + V have saved more lives than Batman and Robin",false),
        Question("A programmer is always a PC repairman.",false),
        Question("The first high-level (very close to real English that we use to communicate) programming language was FORTRAN. invented in 1954 by IBM’s John Backus.",true),
        Question("Guido van Rossum was also reading the published scripts from “Monty Python’s Flying Circus”, a BBC comedy series from the 1970s. Van Rossum thought he needed a name that was short, unique, and slightly mysterious, so he decided to call the language Python..", true)
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
createItemTouchHelper().attachToRecyclerView(rvQuestions)
    }

    private fun createItemTouchHelper(): ItemTouchHelper {

        val callback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

            // Enables or Disables the ability to move items up and down.
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            // Callback triggered when a user swiped an item.
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                if (((direction == ItemTouchHelper.RIGHT) and (questions[position].answer)) ||
                    ((direction == ItemTouchHelper.LEFT) and (!questions[position].answer))){
                    questions.removeAt(position)
                } else {
                    Snackbar.make(constraintLayout, "The item_question won't be removed", Snackbar.LENGTH_SHORT).show()
                }

                questionAdapter.notifyDataSetChanged()
            }
        }
        return ItemTouchHelper(callback)
    }

}
