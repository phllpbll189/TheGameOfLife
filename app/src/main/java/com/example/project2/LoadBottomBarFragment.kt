package com.example.project2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class LoadBottomBarFragment: Fragment(R.layout.load_bottom_bar) {
    //This is a fragment specifically for the cancel button on load
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.load_bottom_bar, container, false)
        val button: Button = view.findViewById(R.id.cancelLoad)
        button.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }
        return view
    }



}