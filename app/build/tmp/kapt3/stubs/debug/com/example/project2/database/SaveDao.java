package com.example.project2.database;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u0007H\'\u00a8\u0006\t"}, d2 = {"Lcom/example/project2/database/SaveDao;", "", "addGrid", "", "Grid", "Lcom/example/project2/database/SavedGrid;", "getSaves", "Landroidx/lifecycle/LiveData;", "", "app_debug"})
public abstract interface SaveDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM SavedGrid")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.project2.database.SavedGrid>> getSaves();
    
    @androidx.room.Insert()
    public abstract void addGrid(@org.jetbrains.annotations.NotNull()
    com.example.project2.database.SavedGrid Grid);
}