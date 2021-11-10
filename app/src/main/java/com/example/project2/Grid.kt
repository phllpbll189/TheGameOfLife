package com.example.project2
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

const val COLUMN_COUNT = 20

class Grid : Fragment(R.layout.grid) {
    private var alive : Int? = null
    private var dead : Int? = null
    private var handler = Handler()

    @Volatile
    var recycler: RecyclerView? = null
    @Volatile
    var viewModel: Square? = null

    fun startHandler() { handler.post(runnable) }
    fun stopHandler() { handler.removeCallbacks(runnable) }
    private fun Boolean.toInt() = if (this) 1 else 0

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
        recycler?.layoutManager = GridLayoutManager(view.context, COLUMN_COUNT)
        recycler?.adapter = gridAdapter(viewModel!!)

        alive = ResourcesCompat.getColor(resources, R.color.alive, null)
        dead = ResourcesCompat.getColor(resources, R.color.dead, null)

        return view
    }

    private fun squareChecker(){
        val squares = viewModel!!.getSquares()
        var toFlip = mutableListOf<Boolean>()

        for(i in 0..399){

            var neighbors = 0
            //tracks rows, columns
            val row = i/COLUMN_COUNT // if 2 then 2nd row
            val col = i % COLUMN_COUNT
            val right_col = (i + 1) % COLUMN_COUNT
            val left_col = (i + 19) % COLUMN_COUNT
            var top_row = (row + 19) % 20
            var bot_row = (row + 1) % 20

            //make sure rows are properly set up
            //if(row == 0){ top_row = 19} object animagtor
            //if(row >= 19){ bot_row = 0 }

            // Test neighbors to see if they're alive
            neighbors += squares[top_row * COLUMN_COUNT + col].toInt()
            neighbors += squares[top_row * COLUMN_COUNT + right_col].toInt()
            neighbors += squares[top_row * COLUMN_COUNT + left_col].toInt()

            neighbors += squares[bot_row * COLUMN_COUNT + col].toInt()
            neighbors += squares[bot_row * COLUMN_COUNT + right_col].toInt()
            neighbors += squares[bot_row * COLUMN_COUNT + left_col].toInt()

            neighbors += squares[row * COLUMN_COUNT + left_col].toInt()
            neighbors += squares[row * COLUMN_COUNT + right_col].toInt()

            if(squares[i]){
                toFlip.add(neighbors == 3 || neighbors == 2)
            }else{
                toFlip.add(neighbors == 3)
            }
        }
        viewModel!!.setSquares(toFlip)
    }

    private inner class CellViewHolder(cellView: View, var viewModel: Square) : RecyclerView.ViewHolder(cellView){
        var position: Int? = null
        private var button: View = cellView.findViewById<ConstraintLayout>(R.id.square)
        private var animator = AlphaAnimation(1.0f, 0.0f)

        init {
            animator.duration = 500
            animator.repeatCount = Animation.INFINITE
            animator.repeatMode = Animation.REVERSE
            this.button.setOnClickListener {
                viewModel.flipStatus(position!!)
                color()

            }
        }

        private fun color() {
            if(viewModel.getStatus(position!!)){
                button.setBackgroundColor(alive!!)
                this.button.startAnimation(animator)
            }else{
                button.setBackgroundColor(dead!!)
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
            squareChecker()
            recycler?.adapter?.notifyDataSetChanged()
            handler.postDelayed(this, 1500)
        }
    }

    fun setAliveColor(color: Int){
        alive = color
        recycler?.adapter?.notifyDataSetChanged()
    }
    fun setDeadColor(color: Int){
        dead = color
        recycler?.adapter?.notifyDataSetChanged()
    }
    fun getAliveColor() : Int{ return alive!! }
    fun getDeadColor() : Int{ return dead!! }

}


