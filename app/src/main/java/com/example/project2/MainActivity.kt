package com.example.project2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity(R.layout.activity_main), GameControls, ColorCallback,
    LoadCallback, saveCallBack {
    private val gridfrag = GameGridFragment()
    private val gameBar = BottomBarFragment()
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

    //Change Color Button
    override fun changeColor(){
        val fragment = ColorPickerFragment.newInstance(gridfrag.getAliveColor(), gridfrag.getDeadColor())
        supportFragmentManager.beginTransaction()
            .replace(R.id.GameBarFragment, fragment)
            .addToBackStack(null)
            .commit()
    }

    //Save Button
    override fun saveGame() {
        val fragment = SaveGameFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.GameBarFragment, fragment)
            .addToBackStack(null)
            .commit()
    }

    //Load Button
    override fun loadGame() {
        val fragment = LoadFragment()
        val bottomFrag = LoadBottomBarFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.GridFragment, fragment)
            .replace(R.id.GameBarFragment, bottomFrag)
            .addToBackStack(null)
            .commit()
    }

    //Start Button
    override fun startHandler() {
        gridfrag.startHandler()
    }

    //Stop Button
    override fun stopHandler() {
        gridfrag.stopHandler()
    }

    //Callback for Color Fragment. Sets Color
    override fun onColorSelected(alive: Int, dead: Int){
        gridfrag.setAliveColor(alive)
        gridfrag.setDeadColor(dead)
    }

    //Callback for LoadFragment
    override fun loadGame(mutableList: MutableList<Boolean>) {
        gridfrag.viewModel?.setSquares(mutableList)
    }

    //Callbacks for SaveGameFragment
    override fun getGame(): MutableList<Boolean> {
        return gridfrag.viewModel!!.getSquares()
    }

    override fun onSaveGame() {
        Toast.makeText(this, "Game Successfully Saved", Toast.LENGTH_LONG).show()
    }
}