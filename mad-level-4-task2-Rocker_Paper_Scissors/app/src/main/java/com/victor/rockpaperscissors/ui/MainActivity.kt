package com.victor.rockpaperscissors.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.victor.rockpaperscissors.R
import com.victor.rockpaperscissors.model.Game
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*


const val ROCK = 1
const val PAPER = 2
const val SCISSOR = 3

const val WIN_STATE = 1
const val LOSE_STATE = 2
const val TIE_STATE = 3

class MainActivity : AppCompatActivity() {

    private val mainScope = CoroutineScope(Dispatchers.Main)
    private val games = arrayListOf<Game>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Rock, Paper, Scissors Kotlin"
initViews()
    }

  private fun  initViews(){
        ivRock.setOnClickListener { clickWeapon(ROCK) }
        ivPaper.setOnClickListener { clickWeapon(PAPER) }
        ivScissor.setOnClickListener { clickWeapon(SCISSOR) }
    }

    private fun clickWeapon(weapon: Int) {
        when (weapon) {
            ROCK -> ivYouPicked.setImageResource(R.drawable.rock)
            PAPER -> ivYouPicked.setImageResource(R.drawable.paper)
            SCISSOR -> ivYouPicked.setImageResource(R.drawable.scissors)
        }

        val aiPicked = randomImage()

        when (checkWin(weapon, aiPicked)) {
            WIN_STATE -> tvWinMessage.text = getString(R.string.win_message, "win")
            LOSE_STATE -> tvWinMessage.text = getString(R.string.win_message, "lose")
            TIE_STATE -> tvWinMessage.text = getString(R.string.tie_message)
        }

        mainScope.launch {
            val game = Game(
                date = Date(),
                player = weapon,
                computer = aiPicked,
                result = checkWin(weapon, aiPicked)
            )

        
        }
    }
        /**
         * Get the win state of the user
         */
        private fun checkWin(yourPick: Int, aiPick: Int): Int {
            if (yourPick == aiPick) {
                return TIE_STATE
            }

            if (yourPick == ROCK && aiPick != PAPER) {
                return WIN_STATE
            } else if (yourPick == PAPER && aiPick != SCISSOR) {
                return WIN_STATE
            } else if (yourPick == SCISSOR && aiPick != ROCK) {
                return WIN_STATE
            }

            return LOSE_STATE
        }

        private fun randomImage(): Int {
            when ((1..3).random()) {
                ROCK -> {
                    ivComputerPicked.setImageResource(R.drawable.rock)
                    return ROCK
                }
                PAPER -> {
                    ivComputerPicked.setImageResource(R.drawable.paper)
                    return PAPER
                }
                SCISSOR -> {
                    ivComputerPicked.setImageResource(R.drawable.scissors)
                    return SCISSOR
                }
            }

            return -1

    }
}
