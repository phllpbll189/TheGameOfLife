package com.example.project2.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import java.lang.IllegalStateException
import java.util.concurrent.Executors

private const val DATABASE_NAME = "GridDB"

class GridRepo private constructor(context: Context){
    private val database : GridDatabase = Room.databaseBuilder(
        context.applicationContext,
        GridDatabase::class.java,
        DATABASE_NAME
    ).build()

    //access database interface to view or add
    private val saveDao = database.SaveDao()
    private val executor = Executors.newSingleThreadExecutor()

    fun getGrids(): LiveData<List<SavedGrid>> = saveDao.getSaves()

    fun addGrid(save: SavedGrid) {
        executor.execute{
            saveDao.addGrid(save)
        }
    }

    //used to make sure we initialize in project2Application file
    companion object{
        private var INSTANCE: GridRepo? = null

        fun init(context: Context){
            if (INSTANCE == null){
                INSTANCE = GridRepo(context)
            }
        }

        //use this to access the repo add and save
        fun get(): GridRepo{
            return INSTANCE ?:
            throw IllegalStateException("GridRepo must be initialized")
        }
    }
}