package com.example.project2.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SaveDao {

    @Query("SELECT * FROM SavedGrid")
    fun getSaves(): LiveData<List<SavedGrid>>
    //essentially our query and insert statements for sql database
    @Insert
    fun addGrid(Grid: SavedGrid)
}