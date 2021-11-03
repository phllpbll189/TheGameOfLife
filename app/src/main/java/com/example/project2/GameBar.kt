package com.example.project2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class GameBar : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    private lateinit var controlListener: GameControls
    private var startStop = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bottombar, container, false)

        val start = view.findViewById(R.id.mainbutton) as? Button
        val changeColor = view.findViewById(R.id.changeColor) as? Button
        val load = view.findViewById(R.id.load) as? Button
        val save = view.findViewById(R.id.save) as? Button

        controlListener = activity as GameControls

        start?.setOnClickListener {
            if(startStop % 2 == 0){
                controlListener.startHandler()
            }
            else{
                controlListener.stopHandler()
            }
            //TODO implement
            //from handler call viewmodel.playOne()
            //switch text to "stop"
            //make boolean for handler to see when it should stop
        }
        changeColor?.setOnClickListener {
            //TODO implement
            //should start another datepicker thing
            //should show 2 different columns
            //each column should have 3 inputs ranging from 0 - 255
        }
        load?.setOnClickListener {
            //TODO implement
            //should start another the datepicker thing
            //show a list of all options
        }
        save?.setOnClickListener {
            //TODO implement
            //Save the viewModel's list as a json on disk
        }
        return view
    }

    //Questions
}

//what is the datepicker thing called so i can research it later
//how do I append more items to the end of a json that is stored on disk. IDEA: Overwrite
//how do i call notify data changed from an entirely different fragment
interface GameControls {
    fun startHandler()
    fun stopHandler()
}
