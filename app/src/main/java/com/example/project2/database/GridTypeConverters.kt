package com.example.project2.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class GridTypeConverters {
    //converts list to and from json and uuid's to and from strings
    @TypeConverter
    fun toLifeList(lifeListJson:String):MutableList<Boolean>{
        val type=object :TypeToken<MutableList<Boolean>>(){}.type
        return Gson().fromJson(lifeListJson,type)
    }
    @TypeConverter
    fun toLifeListJson(lifeList:MutableList<Boolean>):String{
        val type=object :TypeToken<MutableList<Boolean>>(){}.type
        return Gson().toJson(lifeList,type)
    }

    @TypeConverter
    fun toUUID(uuid: String): UUID{
        return UUID.fromString(uuid)
    }

    @TypeConverter
    fun fromUUID(uuid: UUID): String {
        return uuid.toString()
    }
}