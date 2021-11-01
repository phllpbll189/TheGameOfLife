package com.example.project2

import androidx.lifecycle.ViewModel

class Square : ViewModel() {
    private var color = mutableListOf<Int>(0x00, 0x00, 0x00)
    private var lifeTracker: MutableList<Boolean> = mutableListOf<Boolean>()



    //make it private and use getter and setters incase i will need to add functionality later.
    fun addSquare(){
        lifeTracker.add(false)
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
    }
}