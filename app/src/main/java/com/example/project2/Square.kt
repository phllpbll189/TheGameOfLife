package com.example.project2

import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModel
import kotlin.coroutines.coroutineContext

class Square : ViewModel() {
    private var allSquares: MutableList<Boolean> = mutableListOf<Boolean>()

    fun generateSquares(){
        while(allSquares.size != 400){
            allSquares.add(false)
        }
    }

    fun flipStatus(location: Int){ allSquares[location]=!allSquares[location] }
    fun getStatus(location: Int): Boolean{ return allSquares[location] }

    fun getSquares(): MutableList<Boolean>{ return allSquares }
    fun setSquares(newSquares : MutableList<Boolean>){ allSquares = newSquares}
}