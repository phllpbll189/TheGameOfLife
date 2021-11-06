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
import android.widget.Toast
import android.os.Looper

var COLOR = mutableListOf<Int>(0xff, 0xa5, 0x08)
class Grid : Fragment(R.layout.grid) {
    private var handler = Handler()

    @Volatile
    var recycler: RecyclerView? = null

    @Volatile
    var viewModel: Square? = null

    @Volatile
    var gamePlaying = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.grid, container, false)

        //setup view model
        val provider: ViewModelProvider = ViewModelProvider(this)
        viewModel = provider.get(Square::class.java)
        viewModel?.generateSquares()

        //setup recycler
        recycler = view?.findViewById(R.id.GridRecycler) as RecyclerView
        recycler?.layoutManager = GridLayoutManager(view.context, 20)
        recycler?.adapter = gridAdapter(viewModel!!)

        return view
    }

    fun startHandler() {
        //TODO LAST
        handler.post(runnable)
    }

    fun stopHandler() {
        //TODO("Not yet implemented")
        handler.removeCallbacks(runnable)
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

    private val runnable: Runnable = object : Runnable {
        override fun run() {
            recycler?.adapter?.notifyDataSetChanged()

            handler.postDelayed(this, 2000)
        }
    }
    // +1, -1,
    // +19, +20, +21,
    // -19,-20, -21
    //left is +19 then %20
    //I Could also reformat to [][]
    private fun squareChecker(){
        var squares = viewModel?.getSquares()
        for(square in squares!!){


        }
    }

    fun Boolean.toInt() = if (this) 1 else 0
}


