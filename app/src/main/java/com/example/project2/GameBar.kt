package com.example.project2

import android.net.wifi.p2p.WifiP2pManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.Fragment

class GameBar : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    lateinit var controlListener: MyInterface

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

        controlListener = activity as MyInterface

        start?.setOnClickListener {
            //TODO implement
            //start handler for the timer
            //from handler call viewmodel.playOne()
            controlListener.doSomething()
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

    interface MyInterface {
        fun doSomething()
    }

    //Questions
    //how do i call notify data changed from an entirely different fragment
    //how do I append more items to the end of a json that is stored on disk. IDEA: Overwrite
    //what is the datepicker thing called so i can research it later

}