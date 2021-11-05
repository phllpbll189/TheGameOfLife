package com.example.project2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity(R.layout.activity_main), GameControls {
    private val gridfrag = Grid()
    private val gameBar = GameBar()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .add(R.id.GridFragment, gridfrag)
                .add(R.id.GameBarFragment, gameBar)
                .commit()
        }
    }

    override fun startHandler() {

        gridfrag.startHandler()
    }

    override fun stopHandler() {
        gridfrag.stopHandler()
    }
}