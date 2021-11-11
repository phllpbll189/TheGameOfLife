package com.example.project2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project2.database.GridRepo
import com.example.project2.database.SavedGrid

class LoadFragment : Fragment(R.layout.grid) {
    private val gridRepo = GridRepo.get()
    private var model: LiveData<List<SavedGrid>>? = null
    private var adapter: Adapter = Adapter(emptyList())
    var recycler: RecyclerView? = null
    var controlListener: LoadCallback? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.grid, container, false)
        model = gridRepo.getGrids()

        recycler = view?.findViewById(R.id.GridRecycler) as RecyclerView
        recycler?.layoutManager = LinearLayoutManager(view.context)
        recycler?.adapter = adapter
        controlListener = activity as LoadCallback
        return view
    }

    private inner class SaveViewHolder(cellView: View) : RecyclerView.ViewHolder(cellView){
        private lateinit var savedGrid: SavedGrid
        private var button: View = cellView.findViewById(R.id.SaveTemplate)
        private val name: TextView = itemView.findViewById(R.id.GridName)

        init {
            this.button.setOnClickListener {
                controlListener!!.loadGame(savedGrid?.lifeList)
                activity?.supportFragmentManager?.popBackStack()
            }
        }

        fun setup(savedGrid: SavedGrid){
            this.savedGrid = savedGrid
            name.text = savedGrid.name
        }
    }

    override fun onStart() {
        super.onStart()
        model = gridRepo.getGrids()

        model?.observe(viewLifecycleOwner, Observer {
            saves -> saves?.let{ updateUI(saves)}
        })
        recycler?.adapter = adapter
    }

    private fun updateUI(saves: List<SavedGrid>){
        this.adapter.model = saves
        recycler?.adapter = adapter
    }

    private inner class Adapter(var model: List<SavedGrid>): RecyclerView.Adapter<SaveViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaveViewHolder {
            val inflater:LayoutInflater = LayoutInflater.from(parent.context)
            val cellView: View = inflater.inflate(R.layout.saved_game, parent, false)
            return SaveViewHolder(cellView)
        }

        override fun onBindViewHolder(holder: SaveViewHolder, position: Int) {
            holder.setup(model[position])
        }

        override fun getItemCount(): Int {
            return model.size
        }
    }
}

interface LoadCallback {
    fun loadGame(mutableList: MutableList<Boolean>)
}