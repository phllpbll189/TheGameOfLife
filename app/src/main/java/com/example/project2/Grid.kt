package com.example.project2

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.textclassifier.ConversationActions
import android.widget.GridLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
var COLOR = mutableListOf<Int>(0xff, 0xa5, 0x08)
class Grid : Fragment(R.layout.grid){
    private lateinit var recycler: RecyclerView
    lateinit var viewModel: Square
    var gamePlaying = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.grid, container, false)
        val provider: ViewModelProvider = ViewModelProvider(this)
        val viewModel = provider.get(Square::class.java)
        viewModel.generateSquares()

        this.recycler = view.findViewById(R.id.GridRecycler) as RecyclerView
        recycler.layoutManager = GridLayoutManager(container?.context, 20)
        recycler.adapter = gridAdapter(viewModel)


        return view
    }



    var handler = Handler { message ->

        //while loop here and timer here
        this.gamePlaying = true
        val recycler = recycler

        while (gamePlaying) {
            Thread.sleep(1000)
        }
        true
    }


    fun startHandler() {
        handler.sendEmptyMessage(1)
    }

    fun stopHandler() {
        //TODO("Not yet implemented")
    }

    private inner class CellViewHolder(cellView: View, var viewModel: Square) : RecyclerView.ViewHolder(cellView){
        var position: Int? = null
        private var button: View = cellView.findViewById<ConstraintLayout>(R.id.buttonHolder)

        init {
            this.button.setOnClickListener {
                viewModel.flipStatus(position!!)
                color()
            }
        }

        private fun color() {
            if(viewModel.getStatus(position!!)){
                val ourColor = viewModel.getColor()
                button.setBackgroundColor(Color.rgb(ourColor[0], ourColor[1], ourColor[2]))
            }else{
                button.setBackgroundColor(Color.rgb(COLOR[0], COLOR[1], COLOR[2]))
            }
        }

        fun setup(position: Int){
            this.position = position
            color()
        }
    }

    private inner class gridAdapter(var viewModel: Square): RecyclerView.Adapter<CellViewHolder>(){
        val NUM_CELLS: Int = 400

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CellViewHolder {
            val inflater: LayoutInflater = LayoutInflater.from(parent.context)
            val cellView: View = inflater.inflate(R.layout.square, parent, false)
            return CellViewHolder(cellView, viewModel)
        }

        override fun onBindViewHolder(holder: CellViewHolder, position: Int) {
            holder.setup(position)
        }

        override fun getItemCount(): Int {
            return NUM_CELLS
        }
    }
}
