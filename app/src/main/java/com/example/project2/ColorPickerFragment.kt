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
    private var alive: Int? = null
    private var dead: Int? = null
    private lateinit var deadPreview: View
    private lateinit var alivePreview: View
    private lateinit var deadText: EditText
    private lateinit var aliveText: EditText
    private lateinit var cancel: Button
    private lateinit var done: Button
    private lateinit var controlListener: Callbacks


    override fun onCreate(saveInstanceState: Bundle?){
        super.onCreate(saveInstanceState)
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

        //get previews activity
        controlListener = activity as Callbacks

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
            override fun afterTextChanged(s: Editable?) {} //TODO FIX THIS
        }

        aliveText.addTextChangedListener(aliveWatcher)
        deadText.addTextChangedListener(deadWatcher)

        done.setOnClickListener {
            controlListener.onColorSelected(alive!!, dead!!)
        }

        cancel.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }


    }

    companion object {
        fun newInstance(alive: Int, dead: Int): ColorPickerFragment{
            val args = Bundle().apply {
                putSerializable(COLOR_ALIVE, alive)
                putSerializable(COLOR_DEAD, dead)
            }

            return ColorPickerFragment().apply { arguments = args }
        }
    }
}
interface Callbacks {
    fun onColorSelected(alive: Int, dead: Int)
}