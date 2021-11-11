package com.example.project2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class BottomBarFragment : Fragment() {
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
                startStop += 1
                start.text = getString(R.string.stopButton)
                load?.isEnabled = false
                save?.isEnabled = false
                changeColor?.isEnabled = false
            }
            else{
                controlListener.stopHandler()
                startStop += 1
                start.text = getString(R.string.startButton)
                changeColor?.isEnabled = true
                load?.isEnabled = true
                save?.isEnabled = true
            }
        }
        changeColor?.setOnClickListener {
            controlListener.changeColor()
        }
        load?.setOnClickListener {
            controlListener.loadGame()
        }
        save?.setOnClickListener {
            controlListener.saveGame()
        }
        return view
    }
}

interface GameControls {
    fun startHandler()
    fun stopHandler()
    fun changeColor()
    fun saveGame()
    fun loadGame()
}
