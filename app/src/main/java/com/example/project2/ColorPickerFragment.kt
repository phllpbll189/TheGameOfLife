package com.example.project2

import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

private const val COLOR_ALIVE = "AliveColor"
private const val COLOR_DEAD = "DeadColor"

class ColorPickerFragment : Fragment(){
    //Color for both alive and dead states
    private var alive: Int? = null
    private var dead: Int? = null
    //preview sqaures to show color before selection
    private lateinit var deadPreview: View
    private lateinit var alivePreview: View
    //edit Hex to see different colors
    private lateinit var deadText: EditText
    private lateinit var aliveText: EditText
    //cancel or approve button and a callback handle for Main Activity
    private lateinit var cancel: Button
    private lateinit var done: Button
    private lateinit var controlListener: ColorCallback


    override fun onCreate(saveInstanceState: Bundle?){
        super.onCreate(saveInstanceState)
        //set as current colors
        alive = arguments?.getSerializable(COLOR_ALIVE) as Int
        dead = arguments?.getSerializable(COLOR_DEAD) as Int
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.color_picker, container, false)

        deadPreview = view.findViewById(R.id.deadPreview) as ConstraintLayout
        alivePreview = view.findViewById(R.id.alivePreview) as ConstraintLayout
        deadText = view.findViewById(R.id.dead) as EditText
        aliveText = view.findViewById(R.id.alive) as EditText
        cancel = view.findViewById(R.id.cancel) as Button
        done = view.findViewById(R.id.done) as Button

        //set current colors as background of previews
        deadPreview.setBackgroundColor(dead!!)
        alivePreview.setBackgroundColor(alive!!)

        //get activity callback handle for Main activity
        controlListener = activity as ColorCallback

        //gives the current hex as a hint
        aliveText.hint = ResourcesCompat.getColor(resources, R.color.alive, null)
            .toString(16)
            .uppercase()
            .drop(0)

        deadText.hint = ResourcesCompat.getColor(resources, R.color.dead, null)
            .toString(16)
            .uppercase()
            .drop(0)

        return view

    }

    override fun onStart() {
        super.onStart()
        //alive and dead watcher just wait unil there is a valid color input and paints the previews
        val aliveWatcher = object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null) {
                    if(s.length == 6){
                        alive = Color.parseColor("#" + s.toString())
                        alivePreview.setBackgroundColor(alive!!)
                    }
                }
            }
            override fun afterTextChanged(s: Editable?) {}
        }

        val deadWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null) {
                    if(s.length == 6){
                        dead = Color.parseColor("#" + s.toString())
                        deadPreview.setBackgroundColor(dead!!)
                    }
                }

            }
            override fun afterTextChanged(s: Editable?) {}
        }

        //adds created watchers for for the listeners
        aliveText.addTextChangedListener(aliveWatcher)
        deadText.addTextChangedListener(deadWatcher)

        //Sets the color and goes back to game screen
        done.setOnClickListener {
            controlListener.onColorSelected(alive!!, dead!!)
            activity?.supportFragmentManager?.popBackStack()
        }

        //goes back to game screen
        cancel.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }


    }

    companion object {
        //object to call itself because it needs the colors of the current game
        fun newInstance(alive: Int, dead: Int): ColorPickerFragment{
            val args = Bundle().apply {
                putSerializable(COLOR_ALIVE, alive)
                putSerializable(COLOR_DEAD, dead)
            }

            return ColorPickerFragment().apply { arguments = args }
        }
    }
}
interface ColorCallback {
    fun onColorSelected(alive: Int, dead: Int)
}