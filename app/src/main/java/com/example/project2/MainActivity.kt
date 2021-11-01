package com.example.project2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(savedInstanceState == null){
            val gridfrag = Grid()
            val gameBar = GameBar()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.GridFragment, gridfrag)
                .add(R.id.GameBarFragment, gameBar)

        }
    }
}