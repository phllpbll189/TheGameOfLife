package com.example.project2.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [SavedGrid::class], version = 1)
@TypeConverters(GridTypeConverters::class)
abstract class GridDatabase : RoomDatabase() {
    //abstract class and function that will be used to access DB later
    abstract fun SaveDao(): SaveDao
}