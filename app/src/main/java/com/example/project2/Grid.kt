package com.example.project2

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
var COLOR = mutableListOf<Int>(0xff, 0xa5, 0x08)
class Grid : Fragment(R.layout.grid) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.grid, container, false)
        val provider: ViewModelProvider = ViewModelProvider(this)
        val viewModel = provider.get(Square::class.java)

        var recycler = view.findViewById(R.id.GridRecycler) as RecyclerView

        if (container != null) {
            recycler.layoutManager = GridLayoutManager(container.context, 20)
        }
        recycler.adapter = gridAdapter(viewModel)

        return view
    }

    private inner class CellViewHolder(cellView: View, var viewModel: Square) : RecyclerView.ViewHolder(cellView){
        var position: Int? = null

        init {
            var button = cellView.findViewById<ConstraintLayout>(R.id.buttonHolder)
            button.setOnClickListener {
                viewModel.flipStatus(position!!)
                color(button)
            } //TODO implement onclick function
            //change from live to dead or vise versa
            //make sure that it is blinking while alive
        }

        private fun color(button: ConstraintLayout) {
            if(viewModel.getStatus(position!!) == true){
                var ourColor = viewModel.getColor()
                button.setBackgroundColor(Color.rgb(ourColor[0], ourColor[1], ourColor[2]))
            }else{
                button.setBackgroundColor(Color.rgb(COLOR[0], COLOR[1], COLOR[2]))
            }
        }

        fun setup(position: Int){
            viewModel.addSquare()
            this.position = position
        }
    }

    private inner class gridAdapter(var viewModel: Square): RecyclerView.Adapter<CellViewHolder>(){
        final val NUM_CELLS: Int = 400

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