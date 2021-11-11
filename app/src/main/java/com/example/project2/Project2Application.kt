package com.example.project2

import android.app.Application
import com.example.project2.database.GridRepo

class Project2Application : Application(){
    override fun onCreate() {
        super.onCreate()
        GridRepo.init(this)
    }
}
