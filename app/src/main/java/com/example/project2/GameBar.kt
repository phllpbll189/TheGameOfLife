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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bottombar, container, false)

        val start = view.findViewById(R.id.start) as? Button
        val changeColor = view.findViewById(R.id.changeColor) as? Button
        val load = view.findViewById(R.id.load) as? Button
        val save = view.findViewById(R.id.save) as? Button

        return view
    }
}