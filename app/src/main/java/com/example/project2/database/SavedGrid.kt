package com.example.project2.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

//This is what defines our tables in database
@Entity
data class SavedGrid(var name: String, var lifeList: MutableList<Boolean>, @PrimaryKey val id: UUID = UUID.randomUUID())