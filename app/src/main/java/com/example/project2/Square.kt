package com.example.project2

import androidx.lifecycle.ViewModel

class Square : ViewModel() {
    private var color = mutableListOf<Int>(0x00, 0x00, 0x00)
    var lifeTracker: MutableList<Boolean> = mutableListOf<Boolean>()

    fun playOne(){
        //TODO Implement all death/life cases
        //somehow need to call notifyDataSetChanged
    }
    fun generateSquares(){
        while(lifeTracker.size != 400){
            lifeTracker.add(false)
        }
    }
    fun flipStatus(location: Int){
        lifeTracker[location]=!lifeTracker[location]
    }
    fun getStatus(location: Int): Boolean{
        return lifeTracker[location]
    }
    fun getColor() : MutableList<Int>{
        return color
    }
    fun setColor(color: MutableList<Int>){
        this.color = color
    }//TODO move all color objects to the color xml file
    fun getSquares(): MutableList<Boolean>{
        return lifeTracker
    }
}