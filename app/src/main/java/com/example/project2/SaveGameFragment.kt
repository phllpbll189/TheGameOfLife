package com.example.project2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.project2.database.GridRepo
import com.example.project2.database.SavedGrid
import java.time.Duration

const val GRID = "current_grid"

class SaveGameFragment: Fragment() {
    private lateinit var doneButton: Button
    private lateinit var cancelButton: Button
    private lateinit var name: EditText
    private val gridRepo = GridRepo.get()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.save_game_screen, container, false)
        doneButton = view.findViewById(R.id.confirmButton) as Button
        cancelButton = view.findViewById(R.id.cancelButton) as Button
        name = view.findViewById(R.id.GridEditText) as EditText

        //get functions from activity
        val controlListener = activity as saveCallBack

        doneButton.setOnClickListener {
            val gameName = name.text.toString()

            if(gameName == ""){//Ask for a name if none is entered
                Toast.makeText(view.context, "please enter a name", Toast.LENGTH_LONG).show()
            }else{
                //use getgame to get gamestate and create a SavedGrid
                val squares = controlListener.getGame()
                val save = SavedGrid(gameName, squares)

                //Save game to Database
                gridRepo.addGrid(save)
                controlListener.onSaveGame()
                activity?.supportFragmentManager?.popBackStack()
            }

        }

        //pops the stack to go back
        cancelButton.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }

        return view
    }
}

//used to get functions from MainActivity
interface saveCallBack{
    fun getGame() : MutableList<Boolean>
    fun onSaveGame()
}